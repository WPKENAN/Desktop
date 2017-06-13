#coding:utf8
import urllib.request
import urllib.parse
import http.cookiejar

url1="https://www.three-thinking.com/scorelogin.asp";
url2 = 'http://jwxt.xidian.edu.cn/gradeLnAllAction.do?type=ln&oper=qbinfo&lnxndm=2015-2016%D1%A7%C4%EA%B5%DA%D2%BB%D1%A7%C6%DA(%C1%BD%D1%A7%C6%DA)'
url=url1;

postdata = urllib.parse.urlencode ({
	       'xh2' : '14030130101',
	       'pswd' : '411381'
									}).encode('utf-8')   
req = urllib.request.Request(url,postdata)
req.add_header("User-Agent","Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/48.0.2564.82 Chrome/48.0.2564.82 Safari/537.36")
#req.add_header('User-Agent','Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36')
cjar = http.cookiejar.CookieJar()
opener = urllib.request.build_opener(urllib.request.HTTPCookieProcessor(cjar))
urllib.request.install_opener(opener)
file = opener.open(req)
data = file.read()
#file = open('C:/Users/wangcongchao/Desktop/Pythonspider/爬取西电相关/a.html','wb')
file=open("/home/wpkenan/Desktop/test.html","wb");
file.write(data)
file.close()
    
#url2 = 'http://jwxt.xidian.edu.cn/caslogin.jsp'
#data2 = urllib.request.urlopen(url2).read()
#fh2 = open('C:/Users/wangcongchao/Desktop/Pythonspider/爬取西电相关/b.html','wb')
#fh2.write(data2)
#fh2.close()

