#! /usr/bin/env python  
#coding:utf-8  
  
import sys  
import re  
import urllib2  
import urllib  
import requests  
import cookielib  
  
## 这段代码是用于解决中文报错的问题    
reload(sys)    
sys.setdefaultencoding("utf8")    
#####################################################  
#登录人人  
loginurl = 'http://ids.xidian.edu.cn/authserver/login?service=http%3A%2F%2Fjwxt.xidian.edu.cn%2Fcaslogin.jsp'  
logindomain = 'http://ids.xidian.edu.cn' 
  
class Login(object):  
      
    def __init__(self):  
        self.name = ''  
        self.passwprd = ''  
        self.domain = ''  
  
        self.cj = cookielib.LWPCookieJar()              
        self.opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(self.cj))   
        urllib2.install_opener(self.opener)      
      
    def setLoginInfo(self,username,password,domain):  
        '''''设置用户登录信息'''  
        self.name = username  
        self.pwd = password  
#        self.domain = domain  
  
    def login(self):  
        '''''登录网站'''  
        loginparams = {'username':self.name, 'password':self.pwd}  
        headers = {'User-Agent': 'Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.36 (KHTML, like Gecko)     Ubuntu Chromium/48.0.2564.82 Chrome/48.0.2564.82 Safari/537.36'}  
        req = urllib2.Request(loginurl, urllib.urlencode(loginparams),headers=headers)    
        response = urllib2.urlopen(req)  
        self.operate = self.opener.open(req)  
        thePage = response.read()          
          
if __name__ == '__main__':     
    userlogin = Login()  
    username = '14030130101'  
    password = '193036'  
    domain = logindomain  
    userlogin.setLoginInfo(username,password,domain)  
    userlogin.login()  
