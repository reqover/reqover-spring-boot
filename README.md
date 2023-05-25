### Reqover Spring Boot example

1. Run tests
2. Folder .reqover/reqover-results should appear
3. Run
```
npx reqover@latest generate -f .\.reqover\spec.yml -d .\.reqover\reqover-results --html
```
Or using docker:

```
docker run -v $PWD:/reqover \
-v $PWD/.reqover:/tmp \
-v $PWD/.reqover/spec.yml:/tmp/spec.yml \
reqover/reqover-cli generate -f /tmp/spec.yml -d /tmp/reqover-results --html
```
