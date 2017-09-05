'use strict';
const Generator = require('yeoman-generator');
const mkdirp = require('mkdirp');
const chalk = require('chalk');
const yosay = require('yosay');

module.exports = class extends Generator {
  initializing() {
    this.props = {};
  }
  prompting() {
    // Have Yeoman greet the user.
    this.log(yosay(
      'Welcome to ' + chalk.red('Generator Android MVP Basedev') + ' generator! this like start new project on android studio but with template\
      template inspire from https://github.com/googlesamples/android-architecture'
    ));

    const prompts = [
      {
        name: 'name',
        message: 'Application name?',
        store: true,
        default: this.appname 
      },
      {
        name: 'domain',
        message: 'Company domain?',
        store: true,
        default: 'abdy.com'
      },
      {
        name: 'targetSdk',
        message: 'Target android SDK?',
        store: true,
        default: 26 // Android 8.0 (O(7.1+))
      },
      {
        name: 'minSdk',
        message: 'Minimum android SDK?',
        store: true,
        default: 19 // Android 4.0 (Ice Cream Sandwich)
      }];

    return this.prompt(prompts).then(props => {
      this.props.appDomain = props.domain;
      this.props.appName = props.name;
      this.props.appPackage = this._convert_domain_to_package(props.domain) + "." + props.name;
      this.props.appTargetSdkVersion = props.targetSdk;
      this.props.appMinSdkVersion = props.minSdk;
    });
  }

  writing() {
    var packageDir = this.props.appPackage.replace(/\./g, '/');


    //======Root Directory======//
    var appPath = this.sourceRoot() + '/'; 
    this.fs.copy(appPath + '.gitignore', '.gitignore');
    this.fs.copy(appPath + 'build.gradle', 'build.gradle');
    this.fs.copy(appPath + 'gradle.properties', 'gradle.properties');
    this.fs.copy(appPath + 'gradlew', 'gradlew');
    this.fs.copy(appPath + 'gradlew.bat', 'gradlew.bat');
    this.fs.copy(appPath + 'settings.gradle', 'settings.gradle');
    this.fs.copy(appPath + 'local.properties', 'local.properties');
    this.fs.copy(appPath + 'gradle', 'gradle');


    //======App Directory======//
    
    //src
    mkdirp('app');
    mkdirp('app/src/main/assets');
    mkdirp('app/src/main/java/' + packageDir);
    mkdirp('app/src/androidTest/java/' + packageDir);
    mkdirp('app/src/test/java/' + packageDir);
    this.fs.copy(appPath + 'app/src/main/res', 'app/src/main/res');

    this.fs.copyTpl(appPath + 'README.md', 'README.md', this.props);
    this.fs.copyTpl(appPath + 'app/build.gradle', 'app/build.gradle', this.props);
    this.fs.copyTpl(appPath + 'app/src/main/AndroidManifest.xml', 'app/src/main/AndroidManifest.xml', this.props);
    this.fs.copyTpl(appPath + 'app/src/main/java/com/abdymalikmulky/templates', 'app/src/main/java/' + packageDir, this.props);
    this.fs.copyTpl(appPath + 'app/src/main/res/layout', 'app/src/main/res/layout', this.props);
  
  }

  install() {
    //this.installDependencies();
  }

  _convert_domain_to_package(domain) {
    var splitDomain = domain.split(".");
    var packageName = "";
    for (var i = splitDomain.length - 1; i >= 0; i--) {
      packageName += splitDomain[i];
      if(i > 0) {
        packageName += ".";
      }
    }
    return packageName;
  }

};
