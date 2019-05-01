import pexpect
import sys

def convertToUSDFromC():
    c = pexpect.spawn('java Main.java')
    #c.logfile = sys.stdout.buffer
    
    c.expect('1 for converting .*:')
    c.sendline('1')

    c.expect('What .*:')
    c.sendline('C')
    
    c.expect('Please .*:')
    c.sendline('1')

    c.expect('Please .*:')
    c.sendline('12')

    c.expect('.12.228676245796393')

    c.expect('1 for converting .*:')
    c.sendline('3')
    c.expect('.Bye!!!')

    #print(c)
    c.kill(0)

    print("Successfully converted...")


def exit_program():
    c = pexpect.spawn('java Main.java')
    c.expect('1 for converting .*:')
    c.sendline('3')
    c.expect('.Bye!!!')
    #print(c)
    c.kill(0)
    print("Succesfully exited...")


convertToUSDFromC()
exit_program()
