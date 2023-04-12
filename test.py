# wrapper method: 
def check_url(func): 
    urls = ["youtube.com", "google.at", "bing.com", "habedieehre"]
    def wrapper_check_url(*args, **kwargs):
        # check if url is urls: 
        for url in urls:
            # check if url is substring of args or kwargs: 
            if any(url in u for u in args) or any(url in u for u in kwargs.values()): 
                # if url is containing not allowed substring -> return nothing and print error message
                print("Any url containing '{0}' is not allowed!".format(url))
                return
        # url has been checked and request is allowed
        func(*args, **kwargs)
    return wrapper_check_url

@check_url
def webrequest(url):
    print(url)

webrequest(**{"url": "habedieehre.at"}) # calling method with kwargs parameter
webrequest(*("youtube.at",)) # calling method with args parameter -> "," is imporant here! 
webrequest("youtube.com") # calling method normally