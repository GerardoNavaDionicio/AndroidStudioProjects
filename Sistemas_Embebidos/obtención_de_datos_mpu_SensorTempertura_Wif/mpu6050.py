import machine
import binascii
from math import atan2,sqrt,degrees
import math 
class accel():
    # Global Variables
    GRAVITIY_MS2 = 9.80665
    # Scale Modifiers
    ACCEL_SCALE_MODIFIER_2G = 16384.0
    ACCEL_SCALE_MODIFIER_4G = 8192.0
    ACCEL_SCALE_MODIFIER_8G = 4096.0
    ACCEL_SCALE_MODIFIER_16G = 2048.0

    GYRO_SCALE_MODIFIER_250DEG = 131.0
    GYRO_SCALE_MODIFIER_500DEG = 65.5
    GYRO_SCALE_MODIFIER_1000DEG = 32.8
    GYRO_SCALE_MODIFIER_2000DEG = 16.4

    # Pre-defined ranges
    ACCEL_RANGE_2G = 0x00
    ACCEL_RANGE_4G = 0x08
    ACCEL_RANGE_8G = 0x10
    ACCEL_RANGE_16G = 0x18

    GYRO_RANGE_250DEG = 0x00
    GYRO_RANGE_500DEG = 0x08
    GYRO_RANGE_1000DEG = 0x10
    GYRO_RANGE_2000DEG = 0x18

    FILTER_BW_256=0x00
    FILTER_BW_188=0x01
    FILTER_BW_98=0x02
    FILTER_BW_42=0x03
    FILTER_BW_20=0x04
    FILTER_BW_10=0x05
    FILTER_BW_5=0x06

    # MPU-6050 Registers
    PWR_MGMT_1 = 0x6B
    PWR_MGMT_2 = 0x6C

    ACCEL_XOUT0 = 0x3B
    ACCEL_YOUT0 = 0x3D
    ACCEL_ZOUT0 = 0x3F

    TEMP_OUT0 = 0x41

    GYRO_XOUT0 = 0x43
    GYRO_YOUT0 = 0x45
    GYRO_ZOUT0 = 0x47

    ACCEL_CONFIG = 0x1C
    GYRO_CONFIG = 0x1B
    MPU_CONFIG = 0x1A
    
    
    def __init__(self, i2c, addr=0x68):
        self.iic = i2c
        self.addr = addr
        self.iic.start()
        self.iic.writeto(self.addr, bytearray([107, 0]))
        self.iic.stop()

    def get_raw_values(self):
        self.iic.start()
        a = self.iic.readfrom_mem(self.addr, 0x3B, 14)
        self.iic.stop()
        return a

    def get_ints(self):
        b = self.get_raw_values()
        c = []
        for i in b:
            c.append(i)
        return c

    def bytes_toint(self, firstbyte, secondbyte):
        if not firstbyte & 0x80:
            return firstbyte << 8 | secondbyte
        return - (((firstbyte ^ 255) << 8) | (secondbyte ^ 255) + 1)



#xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
    def get_values(self):
        
        raw_ints = self.get_raw_values()
        
        ac = self.iic.readfrom_mem(self.addr, 0x1C, 1) # Obtiene el valor de una dirección
        ac=int(binascii.hexlify(ac).decode()) #convierte el valor a binario 
        
        if (ac==0): # compra el valor convertdido
            ace=16384
        elif (ac==1):
            ace=8192
        elif (ac==2):
            ace=4049
        elif (ac==3):
            ace=2048
            
        g = self.iic.readfrom_mem(self.addr, 0x1B, 1)
        
        gir=int(binascii.hexlify(g).decode())
        if (gir==0):
            giro=131
        elif (gir==1):
            giro=65.5
        elif (gir==2):
            giro=32.8
        elif (gir==3):
            giro=16.4

            
        vals = {}
        vals["AcX"] = self.bytes_toint(raw_ints[0], raw_ints[1]) / ace 
        vals["AcY"] = self.bytes_toint(raw_ints[2], raw_ints[3]) / ace
        vals["AcZ"] = self.bytes_toint(raw_ints[4], raw_ints[5]) / ace
        
        
        vals["Tmp"] = self.bytes_toint(raw_ints[6], raw_ints[7]) / 340.00 + 36.53
        
        
        vals["GyX"] = self.bytes_toint(raw_ints[8], raw_ints[9])   / giro
        vals["GyY"] = self.bytes_toint(raw_ints[10], raw_ints[11]) / giro
        vals["GyZ"] = self.bytes_toint(raw_ints[12], raw_ints[13])/giro
        
        vals["AX"]= atan2(vals["AcX"],sqrt((pow(vals["AcY"],2)+pow(vals["AcZ"],2))))
        vals["AY"]= atan2(vals["AcY"],sqrt((pow(vals["AcX"],2)+pow(vals["AcZ"],2))))
        
        vals["AX"]=degrees(vals["AX"])
        vals["AY"]=degrees(vals["AY"])
        
        
        return vals  # returned in range of Int16
            # -32768 to 32767


#xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx


    def val_test(self):  # ONLY FOR TESTING! Also, fast reading sometimes crashes IIC
        from time import sleep
        while 1:
            print(self.get_values())
            sleep(0.05)