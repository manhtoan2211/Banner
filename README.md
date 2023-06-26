# Banner
Cross Setting Item

#Implement
~~~
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
~~~
~~~
 dependencies {
		implementation 'com.github.User:Repo:Tag'
	}
~~~
#Json custom type

Do not change key name and value data name. Include in default json data
~~~
<entry>
        <key>banner_data</key>
        <value>[
            {
            "packageName":"com.babydola.launcherios",
            "appName":"Launcher iOS",
            "appLink":"https://play-lh.googleusercontent.com/uRk1aOAIin5dbDPX675zqbRa4o6xAioH65hs4hKFWzC1dvPol6QdxzwzH4n1_FQHxg=s48",
            "bannerLink":"https://box.com/public/static/o48v1o1tuwyhuihl1jcndau3vcfwkidu.png"
            },
            {
            "packageName":"com.appsgenz.controlcenter.phone.ios",
            "appName":"Control Center iOS",
            "appLink":"https://play-lh.googleusercontent.com/JPtKjg5JUY8WaBW6Lw2Dk_92Of2uPbrCdaHjEs8Ru7u0y9rDK9A7Q1r-OSKfqfY3gV1J=s48",
            "bannerLink":"https://box.com/public/static/o48v1o1tuwyhuihl1jcndau3vcfwkidu.png"
            },
            {
            "packageName":"com.babydola.lockscreen",
            "appName":"Lock Screen iOS",
            "appLink":"https://play-lh.googleusercontent.com/OVq8R8n5taOR20WT9TSq10RmkOQcyDhWpKm1iyGS8ABEfHQZQUjIK9W0BrZiM6nTO6M=s48",
            "bannerLink":"https://box.com/public/static/o48v1o1tuwyhuihl1jcndau3vcfwkidu.png"
            }
            ]
        </value>
    </entry>
~~~
