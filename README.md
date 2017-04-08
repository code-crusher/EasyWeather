![hero](https://github.com/code-crusher/EasyWeather/blob/master/images/github-hero.png)
</br>

Easy and quick weather fetching from [OpenWeatherMap](openweathermap.org) API for Android.

--------
###Specs

[![](https://jitpack.io/v/code-crusher/EasyWeather.svg)](https://jitpack.io/#code-crusher/EasyWeather)
<a href="http://www.methodscount.com/?lib=com.github.dextorer%3Asofa%3A1.0.0"><img src="https://img.shields.io/badge/Methods and size-core: 817 | 105 KB-e91e63.svg"/></a>
<a href="http://twitter.com/vatsal__bajpai"><img src="https://img.shields.io/badge/Twitter-@vatsal__bajpai-blue.svg?style=flat" alt="Twitter" data-canonical-src="https://img.shields.io/badge/Twitter-@vatsal__bajpai-blue.svg?style=flat" style="max-width:100%;"></a><br>

###Featured in
<a href="https://android-arsenal.com/details/1/3798"><img src="https://img.shields.io/badge/Android%20Arsenal-EasyWeather-green.svg"/></a>

#Concept Art
![Concept Art](https://github.com/code-crusher/EasyWeather/blob/master/images/concept-art.png)

#Screenshot
![Screenshot](https://github.com/code-crusher/EasyWeather/blob/master/images/screenshot.png)
#Integration
-------------
Add the JitPack repository to your build file, add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
 
 - Using **EasyWeather** is as simple as adding it in `dependencies` of your `build.gradle`:

```gradle
dependencies {
	        compile 'com.github.code-crusher:EasyWeather:v1.2' // not this version code 
	}
```

#Usage
First you would need `API_KEY` from [OpenWeatherMap](openweathermap.org) and place it in your `build.gradle`
```gradle
buildTypes.each {
        it.buildConfigField 'String', 'OWM_API_KEY', "\"API_KEY\""
    }
```
First create `WeatherMap` object:
```Java
 WeatherMap weatherMap = new WeatherMap(this, OWM_API_KEY, LANG);
```
To get **Current Weather** use this in `Activity`:

**By City Name**:
```Java
weatherMap.getCityWeather(city, new WeatherCallback<CurrentWeatherResponseModel>() {
            @Override
            public void success(CurrentWeatherResponseModel response) {
                Log.i(response.toString());
            }

            @Override
            public void failure(String message) {

            }
        });
```
To get temperature in specific units you can use:
```Java
Double temperature = TempUnitConverter.convertToCelsius(response.getMain().getTemp());
```

**By Location Coordinates**:
```Java
weatherMap.getLocationWeather(latitude, longitude, new WeatherCallback<CurrentWeatherResponseModel>() {
            @Override
            public void success(CurrentWeatherResponseModel response) {
                Log.i(response.toString());
            }

            @Override
            public void failure(String message) {

            }
        });
```
To get **Forecast** use this in `Activity` also you need specify `index` to get the specific hour of [3 hour Forecast](http://openweathermap.org/forecast5):

**By City Name:**

```Java
weatherMap.getCityForecast(city, new WeatherCallback<ForecastResponseModel>() {
            @Override
            public void success(ForecastResponseModel response) {
                Log.i(response.toString());
            }

            @Override
            public void failure(String message) {

            }
        });
```


**By Location Coordinates:**

```Java
weatherMap.getLocationForecast(latitude, longitude, new WeatherCallback<ForecastResponseModel>() {
            @Override
            public void success(ForecastResponseModel response) {
                Log.i(response.toString());
            }

            @Override
            public void failure(String message) {

            }
        });
```

To get **DailyForecast** use this in `Activity` also you need specify `index` to get the specific day of [16 day / daily forecast](http://openweathermap.org/forecast5):

**By City Name:**

```Java
weatherMap.getCityDailyForecast(city, [OPTIONAL] "6", new WeatherCallback<DailyForecastResponseModel>() {
            @Override
            public void success(DailyForecastResponseModel response) {
                Log.i(response.toString());
            }

            @Override
            public void failure(String message) {

            }
        });
```


**By Location Coordinates:**

```Java
weatherMap.getLocationDailyForecast(latitude, longitude, [OPTIONAL] "6", new WeatherCallback<DailyForecastResponseModel>() {
            @Override
            public void success(DailyForecastResponseModel response) {
                Log.i(response.toString());
            }

            @Override
            public void failure(String message) {

            }
        });
```

Variable     | Type
-------- | ---
city | String
index | int
latitude    | String
longitude     | String

Issues
=====
Feel free to submit issues and enhancement requests.

Contributing
==========
I would love to welcome contributions and support from other developers. Please refer to each project's style guidelines and guidelines for submitting patches and additions. In general, i follow the "fork-and-pull" Git workflow.

1. **Fork** the repo on GitHub.
2. **Clone** the project to your own machine.
3. **Commit** changes to **development** branch.
4. **Push** your work back up to your fork.
5. Submit a **Pull request** so that i can review your changes
NOTE: Be sure to merge the latest from "upstream" before making a pull request!

#License

> Copyright 2016 Vatsal Bajpai

>Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

>   http://www.apache.org/licenses/LICENSE-2.0

>Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
>WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
>See the License for the specific language governing permissions and
>limitations under the License.
