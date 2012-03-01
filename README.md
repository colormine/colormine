# ColorMine

ColorMine is an open-source Java library that is designed to make working with colors easy.

We're still ironing out the "vision", so keep checking back!

## Getting Started Guide
New here? Check out the [Getting Started Guide](https://github.com/colormine/colorMine/wiki/Getting-Started)

## More information 
Click here for [additional resources and information](https://github.com/colormine/colorMine/wiki/Helpful-links) about color

Find information and demonstrations on our blog, [http://colormine.org](http://colormine.org "Information and Demonstrations at http://colormine.org")
Follow us at [@colorminedev](http://twitter.com/colorminedev/ "@ColorMineDev on Twitter") on Twitter

## Recent Updates

*2012-02-28 : Relative Links*
The color servlets have been converted over to use relative links. This means that the links will be correct regardless of the name you deploy it under, including "ROOT". This enabled us to deploy the app on the aws beanstalk: http://demo.colormine.org

*2012-02-26 : Rebranding*
We've rebranded as ColorMine and moved to GitHub. Exciting!

*2012-02-23 : Better Build Process*
We're now using ant for building the servlet project. This makes us completely windows-friendly, and makes it easier to play nice with other toys like continuous integration servers.

*2012-02-21 : Triad Color Scheme*
Triad Color Scheme Demo is now available!

*2012-02-19 : Complements*
Complements Demo is now live and working!

*2012-02-19 : Better Deployment*
We've combined the startup and reload scripts into one. The script will now attempt to detect if your container is running before shutting it down.

Additionally, there's a new flag (-w) you can pass to skip deployment and generate a .war file instead.

*2012-02-18 : Major Reorganization*
The servlet code has been placed into it's own project. The servlets were created to facilitate the demos and should never have been a part of the main libraries.

The tests have also been put into their own project. This keeps the main library 'pure' and prevents them from being automatically picked up during deployment.

*2012-02-18 : Complements*
The complement code is now working! We had to allow for a small margin of error in order to get past a few rounding issues.

*2012-02-18 : Java 1.7...or not*
The project code builds under 1.7, but we ran into a few snags trying to get it to play nice with Tomcat. Presumably it's just a configuration issue, but we need to keep this as easy to run as possible!