#coding:utf8
import urllib
import urllib2
import cookielib
 
filename = 'cookie.txt'
#声明一个MozillaCookieJar对象实例来保存cookie，之后写入文件
cookie = cookielib.MozillaCookieJar(filename)
opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cookie))
 
#设置请求参数
values = {}
values['xh2'] = "14030130101"
values['pswd'] ="411381"
#values['tbxUserID'] = "XXXXXXX"
#values['InputPwd'] = "XXXXXX"
#values['btnLogin.x'] = "55"
#values['btnLogin.y'] = "23"
postdata = urllib.urlencode(values)
 
#登录教务系统的URL
loginUrl='https://www.three-thinking.com/scorelogin.asp';
#loginUrl = 'http://ids.xidian.edu.cn/authserver/login?service=http%3A%2F%2Fjwxt.xidian.edu.cn%2Fcaslogin.jsp'
#loginUrl='http://192.168.43.144/post.php'
#模拟登录，并把cookie保存到变量
#设置header
user_agent = 'Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.36 (KHTML, like Gecko)     Ubuntu Chromium/48.0.2564.82 Chrome/48.0.2564.82 Safari/537.36'
opener.addheaders.append( ('User-Agent', user_agent) )

#opener.addheaders.append( ('Host', 'yjsgl.fzu.edu.cn') )
#opener.addheaders.append( ('User-Agent', user_agent) )
#opener.addheaders.append(('Accept', 'text/css,*/*;q=0.1'))
#opener.addheaders.append('Cache-Control', 'max-age=0')
#opener.addheaders.append(('Accept-Encoding', 'gzip, deflate'))
#opener.addheaders.append( ('Connection', 'keep-alive') )
#opener.addheaders.append( ('Referer', 'https://www.three-thinking.com/scorelogin.asp') )
try:
    result = opener.open(loginUrl,postdata)
except opener.URLError, e:
    print e.reason
 
for item in cookie:
    print 'Name = '+item.name
    print 'Value = '+item.value


fh=open('pc.html','wb');
fh.write(result.read());
fh.close();
#保存cookie到cookie.txt中
#cookie.save(ignore_discard=True, ignore_expires=True)
#利用cookie请求访问另一个网址，此网址是成绩查询网址
#gradeUrl = 'https://www.three-thinking.com/scorelogin.asp'
#请求访问成绩查询网址
#result = opener.open(gradeUrl)
#print result.read()
