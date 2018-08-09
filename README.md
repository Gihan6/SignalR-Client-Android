# SignalR Client For Android
Android SignalR Client for Asp.Net Core SignalR server
# Samples
https://github.com/vkusenko/SignalR-Client-Android/tree/master/app
# How to use
## The first way
1. download this repo
2. import module "aspnetsignalr" to project
3. add module "aspnetsignalr" to the app dependencies
 > - [x] implementation project(':aspnetsignalr')
----
## The second way
1. download *.aar file from aars directory
2. copy to libs directory in your project
3. put code to Top level Gradle file
 ```
 allprojects {
    repositories {
        google()
        jcenter()
        // For module with aar file in it
        flatDir {
            dirs 'libs'
        }
    }
}
```
4. add module "aspnetsignalr" to the app dependencies
 > - [x] implementation(name: 'aspnetsignalr-1*', ext: 'aar')
5. add module "aspnetsignalr" dependencies to the app dependencies
 > - [x] implementation 'org.java-websocket:Java-WebSocket:1.3.8*'
 > - [x] implementation 'com.google.code.gson:gson:2.8.5*'
