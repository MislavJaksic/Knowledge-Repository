## [How to Do Application Logging Right](https://web.archive.org/web/20170810092449/http://arctecgroup.net/pdf/howtoapplogging.pdf)

It talks about building audit logs for security analysts.  

Beware of horrific log messages:
* `Aug 11 09:11:19 xx null pif ? exit! 0` - meaningless
* `Message 202 User tran-sitioning priv level` - omits the user identity and has a secret code
* `userenv[error] 1040 XYZ-CORP\wsupx No descrip-tionavailable` - honest and useless

Log events such as:
* authentication, authorization, and access events:
    * successful and failed authentication or authorization decisions
    * system access, data access, and application component access
    * remote access, including from one application component to another in a distributed environment
* changes:
    * system or application changes (especially privilege changes)
    * data changes (including creation and destruction)
    * application and component installation and changes.
* availability issues:
    * startups and shutdowns of systems, applications, and application modules or components
    * faults and errors, especially errors affecting the application’s availability
    * backup successes and failures that affect availability
* resource issues:
    * exhausted resources, exceeded capacities
    * connectivity issues and problems
    * reached limits
* “badness” or threats:
    * invalid inputs and other likely application abuses
    * other security issues known to affect the application

Best logs provide answers without having the application:
* WHO was involved? - `username` provides the answer
* WHAT happened? - `object` or `status` provide the answer
* WHERE did it happen? - `system`, `application`, `component` or `source` provide the answer
* WHEN did it happen? - `time stamp` or `time zone` provide the answer
* WHY did it happen? - `reason` provides the answer
* HOW did it happen? - `action` provides the answer

An example of an exemplary log message: `2010/12/31 10:00:01AM GMT+7 priority=3, system=mainserver, module=authentication, source=127.0.0.1, user=anton(idp:solar), action=login, object=database, status=failed, reason="password incorrect"`

Make sure the log is in human readable form, not XML!  
