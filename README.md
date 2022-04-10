# What is this?

Just Experiment for using golang in android app.

# Usage

## Generating aar
Run

```bash
cd server
go get -d golang.org/x/mobile/cmd/gomobile
gomobile bind -v -o ../client/app/libs/server.aar -target=android ./lib
```