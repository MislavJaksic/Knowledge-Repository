## [requests](https://requests.readthedocs.io/en/master/)

Features:
* Keep-Alive and Connection Pooling
* International Domains and URLs
* Sessions with Cookie Persistence
* Browser-style SSL Verification
* Automatic Content Decoding
* Basic/Digest Authentication
* Elegant Key/Value Cookies
* Automatic Decompression
* Unicode Response Bodies
* HTTP(S) Proxy Support
* Multipart File Uploads
* Streaming Downloads
* Connection Timeouts
* Chunked Requests
* `.netrc` Support


### [Recommended Packages and Extensions](https://requests.readthedocs.io/en/master/community/recommended/)

[CacheControl](PackagesAndExtensions/CacheControl): cache data and set an expiration date

```
class Requester:
    def __init__(self, max_age_days):
        session = requests.Session()
        expiration = ExpiresAfter(days=max_age_days)
        cache = FileCache(settings.cache_path)
        self.control = CacheControl(session, heuristic=expiration, cache=cache)

    def get_json(self, uri):
        return self.control.get(uri).json()
```
