**Aaron Briggs SnagLog Project Plan**

This repository holds files related to the SnagLog project

**Problem Statement**

The paddlers of small rivers are all too familiar with treefalls and snags which block navigation and force time consuming portaging. Increased trip duration due to unplanned portages can be more than mere inconvenience if longer travel times push voyages into the evening hours in areas where daylight is required for safe navigation.

There are many guide books available for paddlers, but none are capable of delivering the timely information required to plan for tree fall related delays. The creation of a web application allowing users to log current tree fall locations and resulting paddling time increases would be of great benefit to the paddling community.

The SnagLog Project seeks to provide paddlers with the ability to log the location of tree falls and retrieve current information
and updated paddling times.  

**Project Technologies/Techniques**

    Authentication and related user roles

    Admin, login required, full create, read, write, update, delete of all data

    Contributor, login required, create snag updates with admin consent, delete, update, own posts

 **Database (MySQL and Hibernate)**

    Store authentication roles

    Store snag related information submitted by users
    
    Store user submitted logs

 **Web Services or APIs**

    Google Maps API -- data processed with JavaScript
    weatherbit API -- data processed with Java

 **Unit Testing** Log4j used. Tests cover 100% of entity classes, no tests were made on the controller classes

 **Site Hosted by AWS** [AWS Link](http://18.218.9.103:8080/snaglog/)
  

**Design**

[Screen Design](https://github.com/abriggs3/snagLog/tree/master/images)

[Database Design](https://github.com/abriggs3/snagLog/blob/master/images/database_design.png)

[Project Plan](https://github.com/abriggs3/snagLog/blob/master/ProjectPlan.md)

[Time Log](https://github.com/abriggs3/snagLog/blob/master/TimeLog.md)

[video demo](https://youtu.be/FCPsJIqlXj4)