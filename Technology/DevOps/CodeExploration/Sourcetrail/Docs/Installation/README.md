## [Installation](https://www.sourcetrail.com/documentation/#Installation)

### OS

#### Windows

[Download](https://github.com/CoatiSoftware/Sourcetrail/releases) and run the `setup.exe`.

#### macOS

[Download](https://github.com/CoatiSoftware/Sourcetrail/releases) and run the `Sourcetrail.dmg`.

#### Linux

[Download](https://github.com/CoatiSoftware/Sourcetrail/releases) the `.tag.gz` and extract it with `$: tar -xzvf Package-Name`.  

Run `$: sudo install.sh` or `$: sudo /opt/sourcetrail/uninstall.sh`.  
Alternatively, use the `AppImage` version.  

Start Sourcetrail with `Sourcetrail.sh`. It will create `~/.config/sourcetrail` for Sourcetrail's settings.  

### Data folder

| Platform | Location                                                                                                                                                                    |
|----------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Windows  | C:/Users/You/AppData/Local/Coati Software/Sourcetrail \(used for dynamic data and settings\)install\_directory/Coati Software/Sourcetrail/data \(used for static app data\) |
| macOS    | ~/Library/Application Support/Sourcetrail                                                                                                                                   |
| Linux    | ~/\.config/sourcetrail                                                                                                                                                      |

### Finding System Header Locations

#### Windows

For `Visual Studio IDE`:
* `<path_to_visual_studio>/VC/include/`

Also try:
* `C:/Program Files (x86)/Windows Kits/`

#### macOS

```
$: gcc -x c++ -v -E /dev/null
```

#### Linux

```
$: gcc -x c++ -v -E /dev/null
OR
$: clang -x c++ -v -E /dev/null
```

### Finding Java Runtime Library Location

Requires Java 8.  
Sourcetrail and JRE version must share the same bit architecture: 32 bit and 32 bit or 64 bit and 64 bit.  

#### Windows

Java Runtime Library, `jvm.dll` is in:
* `<path_to_jre>/bin/client/jvm.dll`

#### macOS

Java Runtime Library, `libjli.dylib` is in:
* `/usr/libexec/java_home`
* `/Library/Java/JavaVirtualMachines/<jdk_version>/Contents/Home`
* `/Library/Java/JavaVirtualMachines/<jdk_version>/Contents/MacOS/libjli.dylib`

#### Linux

Java Runtime Library, `libjvm.so` is in:
* `<path_to_jre>/lib/<arch>/server/libjvm.so`
