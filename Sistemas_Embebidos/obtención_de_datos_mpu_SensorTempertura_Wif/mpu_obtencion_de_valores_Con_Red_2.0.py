#Gerardo Nava Dionicio  - 191801029

from machine import I2C
from machine import Pin
from machine import sleep

import onewire
import ds18x20
import time

import mpu6050
import socket, network, esp, gc

esp.osdebug(None)
gc.collect()


i2c = I2C(scl=Pin(22), sda=Pin(21))     #initializing the I2C method for ESP32
mpu= mpu6050.accel(i2c)

owi=onewire.OneWire(Pin(4))
owi.scan()
stemp=ds18x20.DS18X20(owi)



def temperatura(): #Función para Obtener la Temperatura del sensor de temperatura
    roms=stemp.scan()
    time.sleep(0.5)
    stemp.convert_temp()
    for rom in roms:
        sensor=stemp.read_temp(rom)
    return sensor



def web_page():#Función para mostrar la página web 
    valores1=mpu.get_values() #Función para obtener las medidas de 
    sensor=temperatura()
    html = """
      <html>
          <head>
              <meta name="viewport" content="width=device-width, initial-scale=1">
              <meta http-equiv="refresh" content="5">
          </head>
          <body>
            <p style="text-align:center"><span style="font-size:18px"><strong>Detector de Medidad a traves de ESP32</strong></span></p>
          
          
           <table class="tftable" border="1"  ALIGN="center"> 
                <tr><th>Concepto</th><th>Mediciones</th></tr>
                
                <tr><td> Aceleracion en X </td><td>"""+ str(valores1["AcX"])+"""</td></tr>
                <tr><td> Aceleracion en Y  </td><td>"""+ str(valores1["AcY"])+"""</td></tr>
                <tr><td> Aceleracion en Z  </td><td>"""+ str(valores1["AcZ"])+"""</td></tr>
                <tr><td> Giroscopio  en X  </td><td>"""+ str(valores1["GyX"])+"""</td></tr>
                <tr><td> Giroscopio  en Y  </td><td>"""+ str(valores1["GyY"])+"""</td></tr>
                <tr><td> Giroscopio  en Z  </td><td>"""+ str(valores1["GyZ"])+"""</td></tr>
                <tr><td> Angulo      en X  </td><td>"""+ str(valores1["AX"])+"""</td></tr>
                <tr><td> Angulo      en Y  </td><td>"""+ str(valores1["AY"])+"""</td></tr>
                <tr><td> Temperatura       </td><td>"""+ str(valores1["Tmp"])+"""</td></tr>
                <tr><td> Temperatura Sensor</td><td>"""+ str(sensor)+"""</td></tr>
            </table>
            <p style="text-align:center">By Nava Dionicio Gerardo</p>
          </body>
      </html>
      """
    return html





ssid="Genady_Red"#creación de la red
password="gerardonava123"# asignación de contraseña a la red
red=network.WLAN(network.AP_IF)#designando como acces point sta=estación
red.config(essid=ssid)#asignancdo nombre a la red 
red.config(authmode=2,password=password)#Asignando contraseña
red.config(max_clients=2)#Cantidad de clientes
red.config(channel=3)# canal por donde se estra transmitiendo la red
red.config(hidden=0)#0 es visible, 1 es invisible
red.active(True)#activar la red

while red.active()==False:
    pass
print("Conexión Exitosa")
print(red.ifconfig())#obtiene la Ip, su máscara, su gateway de la red que se acaba de crear




s=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.bind(('',80))
s.listen(2)

while True:
    conn,addr=s.accept()
    print('Conectado desde: %s' % str(addr))
    request=conn.recv(1024)
    print('contenido = %s' % str(request))
    response= web_page()
    conn.send(response)
    conn.close()
    