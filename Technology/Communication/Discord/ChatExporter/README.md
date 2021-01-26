## [Discord Chat Exporter](https://github.com/Tyrrrz/DiscordChatExporter)

Used to export message history from a Discord channel to a file. It works with direct messages, group messages, and server channels, and supports Discord's dialect of markdown as well as all other rich media features.

[Wiki](https://github.com/Tyrrrz/DiscordChatExporter/wiki)  

[Is it against the Discord Terms of Service?](https://github.com/Tyrrrz/DiscordChatExporter/issues/171)  

### Download

Flavors:
* graphical user interface (GUI) for Windows-only
* command line interface (CLI) for Windows, Linux and macOS

Requires .NET Core v3.1 runtime in order to run. Follow the links on the page to download it or wait for the installer to prompt you to download it.  

### Windows GUI

Find and authorize the exporter using a `token`:
* Open (Desktop) Discord
* Press `Ctrl+Shift+I (I as in India)` to show developer tools
* Navigate to the `Application` tab
* Select `Local Storage`, then `https://discord.com`
* Press `Ctrl+R` to reload
* Find `token` near the bottom and copy the value

Download messages:
* Select which `Channel` or private conversation you want to download
* Select the format, restrict date and time, messages per partition and pick if you want to download all media
