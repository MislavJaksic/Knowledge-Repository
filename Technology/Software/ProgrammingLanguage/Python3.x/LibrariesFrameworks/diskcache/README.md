## [diskcache](http://www.grantjenks.com/docs/diskcache/)

```
class FileCache:
    def __init__(self, cache_path):
        self.cache_path = cache_path
        self.cache = Cache(self.cache_path)

    def __enter__(self):
        return self

    def __exit__(self, exc_type, exc_value, traceback):
        self.close()

    def exists(self, key):
        digest = self.digest(key)
        return digest in self.cache

    def get(self, key):
        digest = self.digest(key)
        return self.cache[digest]

    def set(self, key, value, expire_seconds=86400):
        digest = self.digest(key)
        self.cache.set(digest, value, expire=expire_seconds)

    def delete(self, key):
        digest = self.digest(key)
        del self.cache[digest]

    def digest(self, data):
        return hashlib.sha512(str(data).encode()).hexdigest()

    def clear(self):
        self.cache.clear()

    def close(self):
        self.cache.close()
```
