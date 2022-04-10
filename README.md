# What is this?

Just Experiment for using golang in android app.

# Usage

## Generating aar
Run the following to create aar and jar which will be used in client app.

```bash
cd server
go install

go get -d golang.org/x/mobile/cmd/gomobile
gomobile bind -v -o ../client/app/libs/server.aar -target=android ./lib
```