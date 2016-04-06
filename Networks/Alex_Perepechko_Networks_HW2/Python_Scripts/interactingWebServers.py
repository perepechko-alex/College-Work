import urllib
import urllib2
import json

url = 'http://www.ncdc.noaa.gov/cdo-web/api/v2/datasets'
user_agent = 'Mozilla/5.0 (Windows NT 6.1; Win64; x64)'
token = 'DXLeVaLOzZoIYeAAvwknEmyVMMECHqNG'
values = {"status" : "400", "message" : token}
headers = { 'Token' : token }
data = urllib.urlencode(values)

req = urllib2.Request(url, None, headers)
response = urllib2.urlopen(req)
the_page = response.read()

print json.dumps(the_page, sort_keys = True, indent=4, separators=(',',': '))