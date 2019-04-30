import pexpect

c = pexpect.spawn('./main')
c.expect('Enter .*:')
c.sendline('meme')
c.expect('meme')
if c.after == b'meme': 
    print('Works')
