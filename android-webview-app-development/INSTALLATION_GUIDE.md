# 📱 FX Copy Trade - Complete Installation Guide

## Step-by-Step Installation Instructions

### Prerequisites
- ✅ Android Studio (Latest version recommended - Arctic Fox or newer)
- ✅ JDK 8 or higher
- ✅ Android SDK (API 21 - API 34)
- ✅ Internet connection

---

## 🎯 Method 1: Creating New Project (Recommended)

### Step 1: Create New Android Studio Project

1. **Open Android Studio**
2. Click **"New Project"**
3. Select **"Empty Views Activity"** (or "Empty Activity")
4. Click **"Next"**

### Step 2: Configure Project

Set the following details:
- **Name:** `FX Copy Trade`
- **Package name:** `com.fxcopytrade.app`
- **Save location:** Choose your preferred location
- **Language:** `Java` (Important: Not Kotlin)
- **Minimum SDK:** `API 21: Android 5.0 (Lollipop)`
- **Build configuration language:** `Groovy DSL (build.gradle)`

Click **"Finish"** and wait for project to be created.

### Step 3: Project Structure Setup

After project creation, you'll have this structure:
```
FXCopyTrade/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       ├── res/
│   │       └── AndroidManifest.xml
│   └── build.gradle
├── gradle/
└── build.gradle
```

### Step 4: Add Required Folders

Create these folders if they don't exist:

**In `app/src/main/res/`:**
1. Right-click on `res` folder
2. Select **New > Android Resource Directory**
3. Create folder named `xml`
   - Resource type: `xml`
   - Click OK

**Verify these folders exist in `res/`:**
- ✅ `drawable/`
- ✅ `layout/`
- ✅ `mipmap/` (multiple variants)
- ✅ `values/`
- ✅ `xml/` (newly created)

### Step 5: Copy Java Files

Navigate to `app/src/main/java/com/fxcopytrade/app/`

**Delete** the default `MainActivity.java` if it exists.

**Create/Replace these files:**

1. **MainActivity.java**
   - Right-click on package folder
   - New > Java Class
   - Name: `MainActivity`
   - Copy content from provided `MainActivity.java`

2. **SplashActivity.java**
   - New > Java Class
   - Name: `SplashActivity`
   - Copy content from provided `SplashActivity.java`

3. **WebViewClientHelper.java**
   - New > Java Class
   - Name: `WebViewClientHelper`
   - Copy content from provided `WebViewClientHelper.java`

### Step 6: Copy Layout Files

Navigate to `app/src/main/res/layout/`

**Replace/Create:**

1. **activity_main.xml**
   - Delete existing `activity_main.xml`
   - Right-click on `layout` folder
   - New > Layout Resource File
   - Name: `activity_main`
   - Root element: `RelativeLayout`
   - Copy content from provided `activity_main.xml`

2. **activity_splash.xml**
   - New > Layout Resource File
   - Name: `activity_splash`
   - Root element: `RelativeLayout`
   - Copy content from provided `activity_splash.xml`

### Step 7: Copy Values Files

Navigate to `app/src/main/res/values/`

**Replace these files:**

1. **strings.xml** - Replace content
2. **colors.xml** - Replace or create if not exists
3. **themes.xml** - Replace content (or `styles.xml` in older projects)

### Step 8: Copy Drawable File

Navigate to `app/src/main/res/drawable/`

**Create:**
- **splash_background.xml**
  - Right-click on `drawable` folder
  - New > Drawable Resource File
  - Name: `splash_background`
  - Root element: `layer-list`
  - Copy content from provided file

### Step 9: Copy XML Configuration Files

Navigate to `app/src/main/res/xml/`

**Create these files:**
1. **file_paths.xml**
2. **backup_rules.xml**
3. **data_extraction_rules.xml**
4. **network_security_config.xml**

For each:
- Right-click on `xml` folder
- New > XML > Values XML File
- Name: (use filename without .xml)
- Copy content from provided files

### Step 10: Replace AndroidManifest.xml

Navigate to `app/src/main/`

**Replace:**
- **AndroidManifest.xml**
  - Copy entire content from provided file
  - Make sure all activities and permissions are included

### Step 11: Update Gradle Files

#### A. App-level build.gradle

Navigate to `app/build.gradle`

**Replace** entire content with provided `build.gradle` file content

#### B. Project-level build.gradle

Navigate to root `build.gradle`

**Replace** with content from `build.gradle.project` file

#### C. settings.gradle

Navigate to `settings.gradle`

**Replace** with provided content

#### D. gradle.properties

Navigate to `gradle.properties`

**Replace** with provided content

#### E. proguard-rules.pro

Navigate to `app/proguard-rules.pro`

**Replace** with provided content

#### F. Gradle Wrapper

Navigate to `gradle/wrapper/gradle-wrapper.properties`

**Replace** with provided content

### Step 12: Sync Project

1. Click **File > Sync Project with Gradle Files**
2. Wait for sync to complete (may take 2-5 minutes first time)
3. Check for any errors in **Build** tab at bottom

### Step 13: Generate App Icons

**Option A: Use Android Asset Studio (Online)**
1. Visit: https://romannurik.github.io/AndroidAssetStudio/icons-launcher.html
2. Upload your logo or create icon
3. Download the generated icon pack
4. Extract and copy all `mipmap-*` folders to `app/src/main/res/`
5. Replace existing icon files

**Option B: Use Android Studio Image Asset**
1. Right-click on `res` folder
2. Select **New > Image Asset**
3. Icon Type: **Launcher Icons (Adaptive and Legacy)**
4. **Foreground Layer:**
   - Source Asset: Image or Clip Art
   - Path: Select your logo image
   - Resize: Adjust as needed
5. **Background Layer:**
   - Color or Asset
   - Choose background color (e.g., #1976D2)
6. Click **Next** > **Finish**

### Step 14: Build Project

1. Click **Build > Clean Project**
2. Wait for completion
3. Click **Build > Rebuild Project**
4. Check for any build errors

### Step 15: Run the App

#### On Emulator:
1. Click **Tools > Device Manager**
2. Create new virtual device if needed
3. Select device and click **Run**
4. Click green **Run** button (▶) in toolbar
5. Select your virtual device
6. App will install and launch

#### On Physical Device:
1. Enable **Developer Options** on your Android device:
   - Go to Settings > About Phone
   - Tap "Build Number" 7 times
2. Enable **USB Debugging**:
   - Settings > Developer Options > USB Debugging
3. Connect device via USB
4. Click **Run** button
5. Select your device
6. App will install and launch

---

## 🎯 Method 2: Import Existing Project

If you already have all files organized:

### Step 1: Prepare Project Structure

Create this exact folder structure:

```
FXCopyTrade/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── fxcopytrade/
│   │       │           └── app/
│   │       │               ├── MainActivity.java
│   │       │               ├── SplashActivity.java
│   │       │               └── WebViewClientHelper.java
│   │       ├── res/
│   │       │   ├── drawable/
│   │       │   │   └── splash_background.xml
│   │       │   ├── layout/
│   │       │   │   ├── activity_main.xml
│   │       │   │   └── activity_splash.xml
│   │       │   ├── mipmap-*/
│   │       │   │   └── ic_launcher.png (etc.)
│   │       │   ├── values/
│   │       │   │   ├── colors.xml
│   │       │   │   ├── strings.xml
│   │       │   │   └── themes.xml
│   │       │   └── xml/
│   │       │       ├── backup_rules.xml
│   │       │       ├── data_extraction_rules.xml
│   │       │       ├── file_paths.xml
│   │       │       └── network_security_config.xml
│   │       └── AndroidManifest.xml
│   ├── build.gradle
│   └── proguard-rules.pro
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── build.gradle
├── settings.gradle
├── gradle.properties
├── gradlew
├── gradlew.bat
└── local.properties
```

### Step 2: Import in Android Studio

1. Open Android Studio
2. Click **File > Open**
3. Navigate to your `FXCopyTrade` folder
4. Select the root folder (containing `build.gradle`)
5. Click **OK**
6. Wait for project to import and sync

---

## 🔧 Post-Installation Configuration

### 1. Verify Package Name

Open `AndroidManifest.xml` and verify:
```xml
package="com.fxcopytrade.app"
```

### 2. Check Website URL

Open `MainActivity.java` and verify:
```java
private static final String WEBSITE_URL = "https://fxcopytrade.online";
```

### 3. Test Internet Permission

Ensure `AndroidManifest.xml` has:
```xml
<uses-permission android:name="android.permission.INTERNET" />
```

### 4. Update Gradle if Needed

If you get Gradle version errors:
1. Click **File > Project Structure**
2. Select **Project**
3. Update **Android Gradle Plugin Version**
4. Click **OK** and sync

---

## ✅ Verification Checklist

Before running:
- [ ] All Java files copied correctly
- [ ] All XML layouts copied
- [ ] All values files updated
- [ ] AndroidManifest.xml replaced
- [ ] Gradle files updated
- [ ] App icons generated
- [ ] Project synced successfully
- [ ] No build errors
- [ ] Correct package name
- [ ] Website URL configured

---

## 🐛 Common Issues & Solutions

### Issue 1: "Cannot resolve symbol R"
**Solution:**
- Build > Clean Project
- Build > Rebuild Project
- File > Invalidate Caches / Restart

### Issue 2: Gradle sync failed
**Solution:**
- Check internet connection
- Update Gradle version in gradle-wrapper.properties
- File > Sync Project with Gradle Files

### Issue 3: SDK not found
**Solution:**
- Tools > SDK Manager
- Install required SDK versions (API 21 - 34)
- Apply and sync

### Issue 4: Build tools version error
**Solution:**
- Update `compileSdk` and `targetSdk` in app/build.gradle
- Tools > SDK Manager > SDK Tools
- Install latest build tools

### Issue 5: WebView not loading
**Solution:**
- Verify internet permission in manifest
- Check `usesCleartextTraffic="true"` in manifest
- Add network security config

### Issue 6: App crashes on launch
**Solution:**
- Check Logcat for errors
- Verify all activities declared in manifest
- Check if splash screen theme is applied correctly

---

## 📞 Need Help?

If you encounter issues:

1. **Check Logcat** (View > Tool Windows > Logcat)
2. **Read error messages** carefully
3. **Clean and rebuild** project
4. **Check all file paths** and names
5. **Verify package structure** matches

---

## 🎉 Success!

Once installed successfully:
- App will show splash screen for 2 seconds
- Main screen will load fxcopytrade.online
- All features (pull-to-refresh, file upload, downloads) will work
- Back button navigation works
- Exit confirmation works

---

**Ready to build your APK?**

See README.md for build instructions!

**Built with ❤️ for FX Copy Trade**
