# Pastebin

## About
**Pastebin - web application for creating text(paste) and share it<br>
You can get paste by its id<br>
Paste has no deletion-timer<br>
Application do not store ip-adresses**


## How it works
**After sending request to save paste, application save it in MongoDB<br>
When you try to get paste, it caches with Redis, cache stores for 60 minutes**

## Website pages
**/** - Psate creation page<br>
**/{id}** Page with paste which got from database, if paste dont exist you will be redirected to default page<br>
**/about** Page with information about project, by default just black screen

## Getting started
**You must have installed java 17+<br>
For use Pastebin you should download source code and compile it using [maven](https://maven.apache.org/)<br>
After getting .jar package, run it using java -jar PACKAGE_NAME in console**

## Properties
If you want to enable /deleteall command in api, you should '''deleteall.enabled=true''' in application properties

## Contacts
[Github](https://github.com/Iinfy)<br>
Mail: infywmail@gmail.com


