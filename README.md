# generator-android-mvp-basedev [![NPM version][npm-image]][npm-url] [![Dependency Status][daviddm-image]][daviddm-url] 

<!-- [![Build Status][travis-image]][travis-url] -->
<!-- [![Coverage percentage][coveralls-image]][coveralls-url] -->

> android base development with mvp | android-architecture from google approach (https://github.com/googlesamples/android-architecture)

## What is this ?

This is a generator ecosystem by [Yeoman](http://yeoman.io/authoring/index.html) thank helps us to kickstart new projects, prescribing best practices and tools to help you stay productive  and of course make our life is easier.

In this repository I create generator for android development, actually this is my android base development. 
I built this android dev template with offline first approach [Google IO 2016] (https://www.youtube.com/watch?v=70WqJxymPr8&t=2s) and inspired by this [Android Architecture] (https://github.com/googlesamples/android-architecture) and this [Android Job Queue] (https://github.com/yigit/android-priority-jobqueue).


#### The Stack :


- **Network** : [Retrofit](http://square.github.io/retrofit/) 
- **Serialization & Deserialization** : [Gson](https://github.com/google/gson)
- **View Binder** : [Butterknife](https://github.com/JakeWharton/butterknife)
- **Logging** : [Timber](https://github.com/JakeWharton/timber)
- **Image Downloader and Caching** : [Picasso](http://square.github.io/picasso/)
- **Code Generation for Parcelable** : [Parceler](https://github.com/johncarl81/parceler)
- **Publish/Subscribe Event** : [EventBus](https://github.com/greenrobot/EventBus)
- **Job Queue** : [Job-Queue](https://github.com/yigit/android-priority-jobqueue)
- **Debuggin Local DB** : [Android-Db-Debug](https://github.com/amitshekhariitbhu/Android-Debug-Database)
- **Memory Leak Detector** : [LeakCanary](https://github.com/square/leakcanary)
- **ORM Database** : [DBFlow](https://github.com/Raizlabs/DBFlow)

#### *Soon i will add* :

- **Dependency Injection** : [Dagger 2](https://google.github.io/dagger/)
- **ReactiveX** : [RxJava](https://github.com/ReactiveX/RxJava) & [RxAndroid](https://github.com/ReactiveX/RxAndroid)
- **UnitTest** & **UI Test**

## How it works

First, install [Yeoman](http://yeoman.io) and [npm](https://www.npmjs.com/) (we assume you have pre-installed [node.js](https://nodejs.org/)).


### Online

Then, install generator-android-mvp-basedev using [npm](https://www.npmjs.com/) (we assume you have pre-installed [node.js](https://nodejs.org/)).

```bash
npm install -g yo
npm install -g generator-android-mvp-basedev
```

Then generate your new project:

```bash
yo android-mvp-basedev
```

### Offline


First, clone this repository

```bash
git clone git@github.com:abdymm/generator-android-mvp-basedev.git
```

we assume you have already install Yeoman and npm, now enter on repository that you cloned, and open from command line then type 

```bash
npm link
```

That will install your project dependencies and symlink a global module to your local file. After npm is done, you'll be able to call 

```
yo android-mvp-basedev
``` 

without `generator` and you should see the `this.log`, defined earlier, rendered in the terminal. Congratulations, you just built your first generator!



## Getting To Know Yeoman

 * Yeoman has a heart of gold.
 * Yeoman is a person with feelings and opinions, but is very easy to work with.
 * Yeoman can be too opinionated at times but is easily convinced not to be.
 * Feel free to [learn more about Yeoman](http://yeoman.io/).

## License

Apache-2.0 © [abdymalikmulky](abdymm)


[npm-image]: https://badge.fury.io/js/generator-android-mvp-basedev.svg
[npm-url]: https://npmjs.org/package/generator-android-mvp-basedev
[travis-image]: https://travis-ci.org/abdymm/generator-android-mvp-basedev.svg?branch=master
[travis-url]: https://travis-ci.org/abdymm/generator-android-mvp-basedev
[daviddm-image]: https://david-dm.org/abdymm/generator-android-mvp-basedev.svg?theme=shields.io
[daviddm-url]: https://david-dm.org/abdymm/generator-android-mvp-basedev
[coveralls-image]: https://coveralls.io/repos/abdymm/generator-android-mvp-basedev/badge.svg
[coveralls-url]: https://coveralls.io/r/abdymm/generator-android-mvp-basedev
