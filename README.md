stuntguy3000's ten.java submission
==============================

[![ten.java](https://cdn.mediacru.sh/hu4CJqRD7AiB.svg)](https://tenjava.com/)

This is a submission for the 2014 ten.java contest.

- __Name:__ FireFlight
- __Theme:__ How can combat/weapons be improved?
- __Time:__ Time 1 (7/12/2014 00:00 to 7/12/2014 10:00 UTC)
- __MC Version:__ 1.7.9 (latest Bukkit beta)

---------------------------------------

Compilation
-----------

- Download & Install [Maven 3](http://maven.apache.org/download.html)
- Clone the repository: `git clone https://github.com/tenjava/stuntguy3000-t1`
- Compile and create the plugin package using Maven: `mvn`

Maven will download all required dependencies and build a ready-for-use plugin package!

---------------------------------------

Description
----

FireFlight is a plugin which is designed to enhance and unleash the true power of bows, which such fea tures as
 * Trail
    - Leave a Trail of **Fire** behind your arrow
 * Bomber
    - Drop bombs from the sky as your arrow guides the way
 * Hook
    - Hook and catch Mobs and Players onto your Arrow, and send in the direction of your arrow
 * Scatter
    - Fires a configurable amount of arrows, while scattering them in multiple directions
 * Effector
    - When a arrow hits an entity, you transfer all of your active potion effects to it
 * Missile
    - Fires a Missie at an enemy, blowing it up
 * Confuser
    - Confuse your Enemy with your Battlecry
 
 
This plugin is designed for use in a PVP server, as it uses display names and lores to recognize the bows ability.

Configuration Explanation:
----
Coming soon to a GitHub repository near you!

Usage
-----

Using FireFlight is super easy, and works out of the box. To select a Bow, You need to run the **/ff select** command, in which a Popup GUI appears.

![Popup GUI](http://i.imgur.com/sLLMLUc.png "Popup GUI")

This GUI will allow you to click and choose a Bow **provided you have permission** to use it.

Then simply fire the bow and see what happens!

Permissions
----

Permission | Description
------------- | -------------
fireflight.bow.[name]  | Allows permission of Bow [name]. *Notice:* [name] is a Wildcard variable for any Bow, so for example Hook would be **fireflight.bow.hook**
fireflight.command.give  | Permission for /ff give
fireflight.command.info  | Permission for /ff info
fireflight.command.select  | Permission for /ff select

Commands
----
Command  | Description
------------- | -------------
/ff give <Ability> [player] | Give a player a Bow
/ff info <Ability> | View the Information about an Ability
/ff select | Open an inventory GUI for Bow selection