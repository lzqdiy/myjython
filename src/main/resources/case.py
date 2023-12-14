class RequestObj:
	def __init__(self,requestId):
		self.requestid=requestId
		
class ResponseObj:
	def __init__(self,apiId):
		self.apiId=apiId
		
def testAPI(requestObj):
	if requestObj.requestId == "1" :
		responseObj=ResponseObj("/test/1")
	elif requestObj.requestId == "2" :
		responseObj=ResponseObj("/test/2")
	else:
		responseObj=ResponseObj("/test")
	return responseObj
