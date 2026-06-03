# FX Copy Trade - Android WebView Application

Complete Android WebView application for **fxcopytrade.online**

## 📱 Features

- ✅ Full WebView implementation with JavaScript enabled
- ✅ Splash screen with internet connectivity check
- ✅ Pull to refresh functionality
- ✅ File upload support (images, PDFs, etc.)
- ✅ Download manager integration
- ✅ Cookie management
- ✅ Progress bar (0-100%)
- ✅ Back button navigation with exit confirmation
- ✅ External URL handling
- ✅ Hardware acceleration enabled
- ✅ Material Design theme
- ✅ Responsive layout
- ✅ Network state monitoring
- ✅ Error handling

## 📁 Project Structure

```
FXCopyTrade/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/fxcopytrade/app/
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── SplashActivity.java
│   │   │   │   └── WebViewClientHelper.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   └── activity_splash.xml
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   └── themes.xml
│   │   │   │   ├── drawable/
│   │   │   │   │   └── splash_background.xml
│   │   │   │   ├── xml/
│   │   │   │   │   ├── file_paths.xml
│   │   │   │   │   ├── backup_rules.xml
│   │   │   │   │   ├── data_extraction_rules.xml
│   │   │   │   │   └── network_security_config.xml
│   │   │   │   └── mipmap/
│   │   │   │       └── (app icons - use Android Asset Studio)
│   │   │   └── AndroidManifest.xml
│   │   └── proguard-rules.pro
│   └── build.gradle
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── build.gradle
├── settings.gradle
├── gradle.properties
└── README.md
```

## 🚀 Setup Instructions

### 1. Create New Android Studio Project

1. Open Android Studio
2. Click "New Project"
3. Select "Empty Activity"
4. Set:
   - Name: **FX Copy Trade**
   - Package name: **com.fxcopytrade.app**
   - Save location: Your preferred directory
   - Language: **Java**
   - Minimum SDK: **API 21 (Android 5.0)**

### 2. Replace Files

Replace the following files with the provided code:

#### Java Files (app/src/main/java/com/fxcopytrade/app/)
- `MainActivity.java`
- `SplashActivity.java`
- `WebViewClientHelper.java`

#### Layout Files (app/src/main/res/layout/)
- `activity_main.xml`
- `activity_splash.xml`

#### Values Files (app/src/main/res/values/)
- `strings.xml`
- `colors.xml`
- `themes.xml`

#### Drawable Files (app/src/main/res/drawable/)
- `splash_background.xml`

#### XML Files (app/src/main/res/xml/)
Create `xml` folder if it doesn't exist:
- `file_paths.xml`
- `backup_rules.xml`
- `data_extraction_rules.xml`
- `network_security_config.xml`

#### Root Files
- `AndroidManifest.xml` (app/src/main/)
- `build.gradle` (app/)
- `build.gradle` (root - use build.gradle.project)
- `settings.gradle`
- `gradle.properties`
- `proguard-rules.pro` (app/)

### 3. Update AndroidManifest.xml

Add the network security config reference to the `<application>` tag:

```xml
android:networkSecurityConfig="@xml/network_security_config"
```

### 4. Generate App Icons

1. Go to [Android Asset Studio](https://romannurik.github.io/AndroidAssetStudio/icons-launcher.html)
2. Create launcher icons with your logo/design
3. Download and place in respective `mipmap-*` folders:
   - `mipmap-mdpi/`
   - `mipmap-hdpi/`
   - `mipmap-xhdpi/`
   - `mipmap-xxhdpi/`
   - `mipmap-xxxhdpi/`

Files needed:
- `ic_launcher.png` (standard icon)
- `ic_launcher_round.png` (round icon)
- `ic_launcher_foreground.png` (adaptive icon foreground)
- `ic_launcher_background.png` (adaptive icon background)

### 5. Sync Project

1. Click **File > Sync Project with Gradle Files**
2. Wait for sync to complete
3. Resolve any dependencies issues if they appear

### 6. Build and Run

1. Connect Android device or start emulator
2. Click **Run** button (green play icon)
3. Select your device
4. App will install and launch

## 🔧 Configuration

### Website URL
Located in `MainActivity.java`:
```java
private static final String WEBSITE_URL = "https://fxcopytrade.online";
```

### App Name
Located in `strings.xml`:
```xml
<string name="app_name">FX Copy Trade</string>
```

### Theme Colors
Located in `colors.xml`:
```xml
<color name="colorPrimary">#1976D2</color>
<color name="colorPrimaryDark">#0D47A1</color>
<color name="colorAccent">#2196F3</color>
```

### Splash Duration
Located in `SplashActivity.java`:
```java
private static final int SPLASH_DURATION = 2000; // 2 seconds
```

## 📦 Dependencies

- AndroidX Core: 1.12.0
- AppCompat: 1.6.1
- Material Components: 1.11.0
- ConstraintLayout: 2.1.4
- SwipeRefreshLayout: 1.1.0
- WebKit: 1.9.0
- Lifecycle: 2.7.0

## 🔐 Permissions

The app requests the following permissions:

- `INTERNET` - Required for loading website
- `ACCESS_NETWORK_STATE` - Check internet connectivity
- `ACCESS_WIFI_STATE` - Check WiFi state
- `WRITE_EXTERNAL_STORAGE` - For downloads (API ≤28)
- `READ_EXTERNAL_STORAGE` - For file uploads
- `CAMERA` - For camera-based file uploads (optional)
- `READ_MEDIA_IMAGES` - For image uploads (API ≥33)
- `READ_MEDIA_VIDEO` - For video uploads (API ≥33)

## 🛠️ Build Variants

### Debug Build
```bash
./gradlew assembleDebug
```

### Release Build
```bash
./gradlew assembleRelease
```

**Note:** For release builds, you need to configure signing in `build.gradle`:

```gradle
signingConfigs {
    release {
        storeFile file("your-keystore.jks")
        storePassword "your-store-password"
        keyAlias "your-key-alias"
        keyPassword "your-key-password"
    }
}
```

## 📱 Testing

1. **Splash Screen**: Check if it displays for 2 seconds
2. **Internet Check**: Disable internet and verify error dialog
3. **WebView Loading**: Verify website loads correctly
4. **Pull to Refresh**: Swipe down to refresh page
5. **File Upload**: Test image/PDF upload functionality
6. **Download**: Test file downloads
7. **Back Navigation**: Test back button navigation
8. **Exit Dialog**: Test exit confirmation on home page
9. **External Links**: Verify external links open in browser
10. **Progress Bar**: Check loading progress indicator

## 🎨 Customization

### Change App Icon
1. Create icon using Android Asset Studio
2. Replace files in `mipmap-*` folders

### Change Theme Color
Edit `colors.xml` and update primary colors

### Change Splash Background
Edit `splash_background.xml` to customize gradient

### Change Website URL
Update `WEBSITE_URL` in `MainActivity.java`

## 📄 License

This project is provided as-is for the FX Copy Trade application.

## 👨‍💻 Developer Notes

- Minimum SDK: 21 (Android 5.0 Lollipop)
- Target SDK: 34 (Android 14)
- Compile SDK: 34
- Language: Java
- Build System: Gradle 8.2.0

## 🐛 Troubleshooting

### Build Errors
- Clean and rebuild: **Build > Clean Project** then **Build > Rebuild Project**
- Invalidate caches: **File > Invalidate Caches / Restart**

### WebView Not Loading
- Check internet permissions in AndroidManifest.xml
- Verify `usesCleartextTraffic="true"` is set
- Check network security config

### File Upload Not Working
- Verify storage permissions
- Check file paths configuration
- Test on physical device (emulator may have issues)

## 📞 Support

For issues or questions, please contact the development team.

---

**Built with ❤️ for FX Copy Trade**
