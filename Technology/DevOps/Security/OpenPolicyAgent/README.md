## [Open Policy Agent](https://www.openpolicyagent.org/)

### Install

#### macOS

```
$: curl -L -o opa https://openpolicyagent.org/downloads/latest/opa_darwin_amd64
```

#### Linux

```
$: curl -L -o opa https://openpolicyagent.org/downloads/latest/opa_linux_amd64

$: chmod 755 ./opa
```

### Usage

```
$: ./opa eval Opa-Expression
$: ./opa run [Expression-File] [Data-File] [--server]  # REPL (Read-Eval-Print-Loop) mode
```
