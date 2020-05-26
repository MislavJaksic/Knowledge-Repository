## [tmux](https://github.com/tmux/tmux/wiki)

Linux terminal multiplexor: many processes, one terminal.  

### Install

Ubuntu: `sudo apt-get install tmux`  
Mac: `brew install tmux`  

### Usage

Commands are issued through shortcuts, like on `emacs`.  
First, press the `prefix key` then the `command key`.  

```
$: tmux  # -> start a new session
```

```
C+b : set synchronize-panes on  # -> synchronize
C+b : set synchronize-panes off  # -> desynchronize

C-b %  # -> split pane right-left
C-b "  # -> split pane-up-down

C-b Arrow-Key  # -> move between panes

C-d  # -> exit
```
