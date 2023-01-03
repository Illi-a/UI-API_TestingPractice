# AutomatedTests
Just some simple UI/API tests

03.01.2022 was added ability to start UI tests in container with different browsers using Selenoid.

Wanna try?
I had failed configurate tests with docker.
So, if you want to start these tests, you should have installed JDK + MAVEN and Docker.

If you want to start tests without selenoid, you can skip steps 1-5 and comment @BeforeClass in HatorTest
Steps for starting tests with Selenoid: 
If you dont have Selenoid Configuration Manager, follow step 1, if you have on, start with step 2
  1) Download Selenoid Configuration Manager from https://github.com/aerokube/cm/releases/tag/1.8.2
  2) Open CMD in folder that cointain cm.exe
  3) Type "cm.exe selenoid start —vnc" in console
  4) If you want to enable UI (access to UI on http://localhost:8080/) type in console "cm.exe selenoid-ui start"
  5) Type in console "docker pull selenoid/<browserName>:<browserVersion>"(for example "docker pull selenoid/chrome:108.0") 
  6) Open project and start UI or API tests
  UI tests should work with selenoid, browser can be selected in @BeforeClass
  API tests work with RestAssured
