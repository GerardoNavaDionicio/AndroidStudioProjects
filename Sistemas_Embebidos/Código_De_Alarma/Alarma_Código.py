from machine import Pin,PWM
import machine
from time import sleep
buzzer=PWM(Pin(13, Pin.OUT))
buzzer.init(freq=1,duty=0)
v1=Pin(18,Pin.IN,Pin.PULL_UP)
v2=Pin(5,Pin.IN,Pin.PULL_UP)
v3=Pin(17,Pin.IN,Pin.PULL_UP)
v4=Pin(16,Pin.IN,Pin.PULL_UP)
v5=Pin(4,Pin.IN,Pin.PULL_UP)
v6=Pin(0,Pin.IN,Pin.PULL_UP)
v7=Pin(25,Pin.IN,Pin.PULL_UP)
v8=Pin(15,Pin.IN,Pin.PULL_UP)
pb_iniciar=Pin(19,Pin.IN,Pin.PULL_UP)
pb_parar=Pin(21,Pin.IN,Pin.PULL_UP)
flag=False
ciclo=0
def sonar (alarma1):
    buzzer.init(freq=1000,duty=1000)
def apagar(n):
    buzzer.init(freq=1000,duty=0)
    print("")
def datos(n):
    contraseña_values1=[0,0,0,0,0,0,0,0]
    contraseña_values1[0]=v1.value()
    contraseña_values1[1]=v2.value()
    contraseña_values1[2]=v3.value()
    contraseña_values1[3]=v4.value()
    contraseña_values1[4]=v5.value()
    contraseña_values1[5]=v6.value()
    contraseña_values1[6]=v7.value()
    contraseña_values1[7]=v8.value()
    return contraseña_values1;
def comparar(resultado):
    contador=0
    contraseña=[0,1,1,1,1,1,1,1]
    for i in range(0,8):
        if (resultado[i]==contraseña[i]):
            contador+=1
        else:
            contador=contador
    return contador
def alarma(n):
    global flag
    flag=True
def validar_pass(n):
    global flag
    resultado=datos(n);
    contra=comparar(resultado)#Se le manda la posicion del switch Recibe 0 u 8 
    if ((contra==8)and(contador<10)):
        print("Contraseña Correcta, apagando...")
        flag=False
        apagar(1)
pb_iniciar.irq(handler=alarma,trigger=Pin.IRQ_FALLING)
pb_parar.irq(handler=validar_pass,trigger=Pin.IRQ_FALLING)
print("alarma Durmiendo...")
contador=1
while True:
    contador=1
    while flag==True:
        print("Alarma Violada, tienes 10 segundos para desactivar",+ contador)
        contador+=1
        sleep(1)
        if contador>5 and contador<11 and flag==True:
            sonar(1)
        elif contador>10 and flag==True:
            if ciclo>=100:
                ciclo=1
            else:
                ciclo+=10
            buzzer.duty(int(ciclo*1023/100))
        