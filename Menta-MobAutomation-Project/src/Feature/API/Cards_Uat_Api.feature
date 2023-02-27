Feature: Cards API's

  @Get_Balance @Cards
  Scenario Outline: To verify the response of http request of get balance.
  	Given User hit the POST http request "<TokenReq>" for bearer token
  	When User hit the POST http request "<getBalance>" for getting balance amount of customer ID "<CustID>"
  	Then User validate the Response code "<ResCode>"
  	
  	Examples:
			| TokenReq   | getBalance 	 | CustID 					| ResCode |
			| CDTokenURI | getBalanceURI | 0201001006878008	| 000     |
	
	@AGSITgetDetails
	Scenario Outline: To verufy the response of http request of getUserDetails on SIT.
	  Given User Generate Token for API Validation from "<TokenAPI>" for AGORA
	  When User hit the GET http request "<APIName>" and check Status code as "<StatusCode>" for AGORA
	  Then User validate Response code as "<ResponseCode>"
		
		Examples:
			| TokenAPI       | APIName					| StatusCode |
			| agoraAuthToken | getUserDetailsAG | 200        |
			
  @getBalance
  Scenario Outline: To verify the HTTP request for getBalance API.
  	Given User Generate Token for API Validation from "<TokenAPI>" for CD application
  	When User hit the POST http request "<APIName>" and check Status code as "<StatusCode>" for CD application
  	Then User validate Response code as "<ResponseCode>" and Response description as "<ResponseDes>"
  	
  	Examples:
    	| TokenAPI 			| APIName    | StatusCode | ResponseCode | ResponseDes |
    	| tokenGenerate | getBalance | 200        | 000					 | Success     |
    	
  @credit
  Scenario Outline: To verify the HTTP request for credit API.
    Given User Generate Token for API Validation from "<TokenAPI>" for CD application
  	When User hit the POST http request "<APIName>" and check Status code as "<StatusCode>" for CD application
  	Then User validate Response code as "<ResponseCode>" and Response description as "<ResponseDes>"
  	
  	Examples:
    	| TokenAPI 			| APIName | StatusCode | ResponseCode | ResponseDes |
    	| tokenGenerate | credit  | 200        | 000					| Success     |
    	
  @debit
  Scenario Outline: To verify the HTTP request for debit API.
    Given User Generate Token for API Validation from "<TokenAPI>" for CD application
  	When User hit the POST http request "<APIName>" and check Status code as "<StatusCode>" for CD application
  	Then User validate Response code as "<ResponseCode>" and Response description as "<ResponseDes>"
  	
  	Examples:
    	| TokenAPI 			| APIName | StatusCode | ResponseCode | ResponseDes |
    	| tokenGenerate | debit   | 200        | 000					| Success     |  	