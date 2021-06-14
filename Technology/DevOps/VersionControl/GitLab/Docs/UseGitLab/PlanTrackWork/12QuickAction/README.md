## [Quick Actions](https://docs.gitlab.com/ee/user/project/quick_actions.html)

Quick actions are textual shortcuts for actions.  

### Frequent Quick Actions

| Command                                                | Issue | Merge request | Epic |
|--------------------------------------------------------|-------|---------------|------|
| TODO                                                   | TODO  | TODO          | TODO |

### Every Quick Action

| Command                                                | Issue | Merge request | Epic | Action                                                                                                                                                          |
|--------------------------------------------------------|-------|---------------|------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| /tableflip <comment>                                   | ✓     | ✓             | ✓    | Append the comment with \(╯°□°\)╯︵ ┻━┻
                                                                                                                         |
| /shrug <comment>                                       | ✓     | ✓             | ✓    | Append the comment with ¯\\＿\(ツ\)＿/¯
                                                                                                                           |
| /todo                                                  | ✓     | ✓             | ✓    | Add a To Do                                                                                                                                                     |
| /done                                                  | ✓     | ✓             | ✓    | Mark To Do as done                                                                                                                                              |
| /subscribe                                             | ✓     | ✓             | ✓    | Subscribe                                                                                                                                                       |
| /unsubscribe                                           | ✓     | ✓             | ✓    | Unsubscribe                                                                                                                                                     |
| /close                                                 | ✓     | ✓             | ✓    | Close                                                                                                                                                           |
| /reopen                                                | ✓     | ✓             | ✓    | Reopen                                                                                                                                                          |
| /title <new title>                                     | ✓     | ✓             | ✓    | Change title                                                                                                                                                    |
| /award :emoji:                                         | ✓     | ✓             | ✓    | Toggle emoji award                                                                                                                                              |
| /assign me                                             | ✓     | ✓             |      | Assign yourself                                                                                                                                                 |
| /assign @user                                          | ✓     | ✓             |      | Assign one user                                                                                                                                                 |
| /assign @user1 @user2                                  | ✓     | ✓             |      | Assign multiple users
                                                                                                                                         |
| /reassign @user1 @user2                                | ✓     | ✓             |      | Change assignee
                                                                                                                                               |
| /unassign                                              | ✓     | ✓             |      | Remove current assignee                                                                                                                                         |
| /unassign @user1 @user2                                | ✓     | ✓             |      | Remove assignee\(s\)
                                                                                                                                          |
| /milestone %milestone                                  | ✓     | ✓             |      | Set milestone                                                                                                                                                   |
| /remove\_milestone                                     | ✓     | ✓             |      | Remove milestone                                                                                                                                                |
| /label ~label1 ~label2                                 | ✓     | ✓             | ✓    | Add label\(s\)\. Label names can also start without ~ but mixed syntax is not supported                                                                         |
| /relabel ~label1 ~label2                               | ✓     | ✓             | ✓    | Replace existing label\(s\) with those specified                                                                                                                |
| /unlabel ~label1 ~label2                               | ✓     | ✓             | ✓    | Remove all or specific label\(s\)                                                                                                                               |
| /copy\_metadata <\#issue>                              | ✓     | ✓             |      | Copy labels and milestone from another issue in the project                                                                                                     |
| /copy\_metadata <\!merge\_request>                     | ✓     | ✓             |      | Copy labels and milestone from another merge request in the project                                                                                             |
| /estimate <<W>w <DD>d <hh>h <mm>m>                     | ✓     | ✓             |      | Set time estimate\. For example, /estimate 1w 3d 2h 14m
                                                                                                        |
| /remove\_estimate                                      | ✓     | ✓             |      | Remove time estimate                                                                                                                                            |
| /spend <time\(<h>h <mm>m\)> <date\(<YYYY\-MM\-DD>\)>   | ✓     | ✓             |      | Add spent time; optionally specify the date that time was spent on\. For example, /spend time\(1h 30m\) or /spend time\(1h 30m\) date\(2018\-08\-26\)
          |
| /spend <time\(\-<h>h <mm>m\)> <date\(<YYYY\-MM\-DD>\)> | ✓     | ✓             |      | Subtract spent time; optionally specify the date that time was spent on\. For example, /spend time\(\-1h 30m\) or /spend time\(\-1h 30m\) date\(2018\-08\-26\)
 |
| /remove\_time\_spent                                   | ✓     | ✓             |      | Remove time spent                                                                                                                                               |
| /lock                                                  | ✓     | ✓             |      | Lock the thread                                                                                                                                                 |
| /unlock                                                | ✓     | ✓             |      | Unlock the thread                                                                                                                                               |
| /due <date>                                            | ✓     |               |      | Set due date\. Examples of valid <date> include in 2 days, this Friday and December 31st
                                                                       |
| /remove\_due\_date                                     | ✓     |               |      | Remove due date                                                                                                                                                 |
| /weight <value>                                        | ✓     |               |      | Set weight\. Valid options for <value> include 0, 1, 2, etc
                                                                                                   |
| /clear\_weight                                         | ✓     |               |      | Clear weight
                                                                                                                                                  |
| /epic <epic>                                           | ✓     |               |      | Add to epic <epic>\. The <epic> value should be in the format of &epic, group&epic, or a URL to an epic\.
                                                     |
| /remove\_epic                                          | ✓     |               |      | Remove from epic
                                                                                                                                              |
| /promote                                               | ✓     |               |      | Promote issue to epic
                                                                                                                                         |
| /confidential                                          | ✓     |               |      | Make confidential                                                                                                                                               |
| /duplicate <\#issue>                                   | ✓     |               |      | Mark this issue as a duplicate of another issue                                                                                                                 |
| /create\_merge\_request <branch name>                  | ✓     |               |      | Create a new merge request starting from the current issue                                                                                                      |
| /relate \#issue1 \#issue2                              | ✓     |               |      | Mark issues as related
                                                                                                                                        |
| /move <path/to/project>                                | ✓     |               |      | Move this issue to another project                                                                                                                              |
| /zoom <Zoom URL>                                       | ✓     |               |      | Add Zoom meeting to this issue\. \(Introduced in GitLab 12\.4\)                                                                                                 |
| /remove\_zoom                                          | ✓     |               |      | Remove Zoom meeting from this issue\. \(Introduced in GitLab 12\.4\)                                                                                            |
| /target\_branch <local branch name>                    |       | ✓             |      | Set target branch                                                                                                                                               |
| /wip                                                   |       | ✓             |      | Toggle the Work In Progress status                                                                                                                              |
| /approve                                               |       | ✓             |      | Approve the merge request                                                                                                                                       |
| /merge                                                 |       | ✓             |      | Merge \(when pipeline succeeds\)                                                                                                                                |
| /child\_epic <epic>                                    |       |               | ✓    | Add child epic to <epic>\. The <epic> value should be in the format of &epic, group&epic, or a URL to an epic\. \(Introduced in GitLab 12\.0\)
                |
| /remove\_child\_epic <epic>                            |       |               | ✓    | Remove child epic from <epic>\. The <epic> value should be in the format of &epic, group&epic, or a URL to an epic\. \(Introduced in GitLab 12\.0\)
           |
| /parent\_epic <epic>                                   |       |               | ✓    | Set parent epic to <epic>\. The <epic> value should be in the format of &epic, group&epic, or a URL to an epic\. \(introduced in GitLab 12\.1\)
               |
| /remove\_parent\_epic                                  |       |               | ✓    | Remove parent epic from epic \(introduced in GitLab 12\.1\)
                                                                                                   |
