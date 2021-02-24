## [CacheControl](https://cachecontrol.readthedocs.io/en/latest/)

CacheControl is an extension of `requests` that can:
* cache data to different caches
* set a cache expiration data

```
session = requests.Session()
expiration = ExpiresAfter(days=7)
cache = FileCache(".webcache")
control = CacheControl(session, heuristic=expiration, cache=cache)
```
