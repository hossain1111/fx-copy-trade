# 🏗️ Building APK Guide - FX Copy Trade

Complete guide to build release APK for distribution.

---

## 📦 Building Debug APK (For Testing)

### Method 1: Using Android Studio

1. **Open project** in Android Studio
2. Click **Build** menu
3. Select **Build Bundle(s) / APK(s)**
4. Click **Build APK(s)**
5. Wait for build to complete
6. Click **locate** in notification or check:
   ```
   app/build/outputs/apk/debug/app-debug.apk
   ```

### Method 2: Using Gradle Command

```bash
# Windows
gradlew assembleDebug

# Mac/Linux
./gradlew assembleDebug
```

APK location: `app/build/outputs/apk/debug/app-debug.apk`

---

## 🔐 Building Release APK (For Production)

### Step 1: Generate Signing Key

#### Option A: Using Android Studio

1. Click **Build** > **Generate Signed Bundle / APK**
2. Select **APK**
3. Click **Next**
4. Click **Create new...**
5. Fill in details:
   - **Key store path:** Choose location (e.g., `fxcopytrade-keystore.jks`)
   - **Password:** Create strong password (save it!)
   - **Alias:** `fxcopytrade`
   - **Password:** Create alias password (save it!)
   - **Validity:** 25 years
   - **Certificate:**
     - First and Last Name: Your name
     - Organizational Unit: Your team/dept
     - Organization: Your company
     - City/Locality: Your city
     - State/Province: Your state
     - Country Code: Your country (e.g., US)
6. Click **OK**
7. **IMPORTANT:** Save keystore file and passwords securely!

#### Option B: Using Command Line

```bash
keytool -genkey -v -keystore fxcopytrade-keystore.jks -keyalg RSA -keysize 2048 -validity 10000 -alias fxcopytrade
```

Follow prompts to enter passwords and certificate information.

### Step 2: Configure Signing in build.gradle

Open `app/build.gradle` and add before `buildTypes`:

```gradle
android {
    ...
    
    signingConfigs {
        release {
            storeFile file("../fxcopytrade-keystore.jks")
            storePassword "YOUR_STORE_PASSWORD"
            keyAlias "fxcopytrade"
            keyPassword "YOUR_KEY_PASSWORD"
        }
    }
    
    buildTypes {
        release {
            signingConfig signingConfigs.release
            minifyEnabled true
            shrinkResources true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
        ...
    }
}
```

**⚠️ Security Warning:** Don't commit passwords to version control!

### Step 3: Use gradle.properties for Passwords (Recommended)

Create/Edit `gradle.properties` in root:

```properties
RELEASE_STORE_FILE=../fxcopytrade-keystore.jks
RELEASE_STORE_PASSWORD=your_store_password_here
RELEASE_KEY_ALIAS=fxcopytrade
RELEASE_KEY_PASSWORD=your_key_password_here
```

Update `app/build.gradle`:

```gradle
signingConfigs {
    release {
        storeFile file(RELEASE_STORE_FILE)
        storePassword RELEASE_STORE_PASSWORD
        keyAlias RELEASE_KEY_ALIAS
        keyPassword RELEASE_KEY_PASSWORD
    }
}
```

Add `gradle.properties` to `.gitignore`!

### Step 4: Build Release APK

#### Using Android Studio:

1. **Build** > **Generate Signed Bundle / APK**
2. Select **APK**
3. Click **Next**
4. Select existing keystore
5. Enter passwords
6. Click **Next**
7. Select **release** build variant
8. Choose destination folder
9. Click **Finish**
10. Wait for build

APK location: `app/release/app-release.apk`

#### Using Gradle Command:

```bash
# Windows
gradlew assembleRelease

# Mac/Linux
./gradlew assembleRelease
```

APK location: `app/build/outputs/apk/release/app-release.apk`

---

## 📱 Building Android App Bundle (AAB) - For Google Play

### Why AAB?
- Smaller download size for users
- Required for Google Play Store
- Better optimization

### Build AAB:

#### Using Android Studio:

1. **Build** > **Generate Signed Bundle / APK**
2. Select **Android App Bundle**
3. Click **Next**
4. Select keystore and enter passwords
5. Click **Next**
6. Select **release**
7. Click **Finish**

AAB location: `app/release/app-release.aab`

#### Using Gradle:

```bash
# Windows
gradlew bundleRelease

# Mac/Linux
./gradlew bundleRelease
```

AAB location: `app/build/outputs/bundle/release/app-release.aab`

---

## 🔍 Verify APK

### Check APK Information:

```bash
# Get APK info
aapt dump badging app-release.apk

# Check signing
jarsigner -verify -verbose -certs app-release.apk
```

### Using Android Studio:

1. **Build** > **Analyze APK**
2. Select your APK
3. Review size, resources, etc.

---

## 📝 Version Management

### Update Version Before Release

Edit `app/build.gradle`:

```gradle
android {
    defaultConfig {
        versionCode 1      // Increment for each release (1, 2, 3...)
        versionName "1.0.0" // Semantic versioning (1.0.0, 1.0.1, 1.1.0...)
    }
}
```

Version naming:
- **versionCode:** Integer, must increase (e.g., 1, 2, 3, 4...)
- **versionName:** User-visible (e.g., "1.0.0", "1.0.1", "2.0.0")

---

## 🚀 Distribution Options

### 1. Direct Distribution (APK)

**Advantages:**
- ✅ No app store needed
- ✅ Immediate distribution
- ✅ Full control

**How to distribute:**
- Upload to your website
- Send via email
- Share via cloud storage
- Use QR code generator

**User installation:**
- Users need to enable "Install from Unknown Sources"
- Download APK
- Tap to install

### 2. Google Play Store (AAB)

**Requirements:**
- Google Play Developer Account ($25 one-time)
- App compliance with policies
- Privacy policy URL
- Screenshots and store listing

**Steps:**
1. Create developer account
2. Create new app
3. Fill in store listing
4. Upload AAB
5. Set pricing (free/paid)
6. Submit for review

### 3. Alternative App Stores

**Options:**
- Amazon Appstore
- Samsung Galaxy Store
- Huawei AppGallery
- APKPure
- F-Droid (if open source)

---

## 📋 Pre-Release Checklist

Before building release APK:

- [ ] Update version code and name
- [ ] Test all features thoroughly
- [ ] Test on multiple devices/Android versions
- [ ] Check internet connectivity handling
- [ ] Verify file upload/download works
- [ ] Test back button navigation
- [ ] Test exit dialog
- [ ] Verify splash screen displays correctly
- [ ] Check for crashes in Logcat
- [ ] Test with slow internet
- [ ] Enable ProGuard optimization
- [ ] Remove debug logging
- [ ] Update strings.xml if needed
- [ ] Verify app icon looks good
- [ ] Check app name and permissions
- [ ] Generate signed APK with keystore
- [ ] Test signed APK on device
- [ ] Keep keystore and passwords safe!

---

## 🔐 Keystore Security

**CRITICAL:** Protect your keystore!

### Best Practices:

1. **Backup Keystore:**
   - Save multiple copies
   - Store in secure cloud storage
   - Keep offline backup

2. **Password Management:**
   - Use strong passwords
   - Store in password manager
   - Never commit to Git

3. **If Lost:**
   - ❌ **Cannot update app** on Play Store
   - ❌ Must create new app listing
   - ❌ Users must uninstall old version

### Keystore Backup Locations:
- ✅ Encrypted cloud storage
- ✅ External hard drive
- ✅ Password manager vault
- ✅ Secure file server

---

## 📊 APK Size Optimization

### Reduce APK Size:

1. **Enable ProGuard/R8:**
   ```gradle
   buildTypes {
       release {
           minifyEnabled true
           shrinkResources true
       }
   }
   ```

2. **Use WebP images** instead of PNG/JPG

3. **Remove unused resources:**
   ```gradle
   android {
       buildTypes {
           release {
               shrinkResources true
           }
       }
   }
   ```

4. **Enable split APKs** for different architectures:
   ```gradle
   android {
       splits {
           abi {
               enable true
               reset()
               include 'armeabi-v7a', 'arm64-v8a', 'x86', 'x86_64'
               universalApk true
           }
       }
   }
   ```

---

## 🧪 Testing Release APK

### Before Distribution:

1. **Install on Clean Device:**
   ```bash
   adb install app-release.apk
   ```

2. **Test All Features:**
   - App opens without crash
   - Splash screen displays
   - Website loads correctly
   - All WebView features work
   - File upload/download works
   - Back button navigation
   - Exit confirmation
   - No crashes in any scenario

3. **Check Logcat for Errors:**
   ```bash
   adb logcat | grep "com.fxcopytrade.app"
   ```

4. **Test on Different Android Versions:**
   - Android 5.0 (API 21)
   - Android 8.0 (API 26)
   - Android 10 (API 29)
   - Android 12+ (API 31+)

---

## 📱 Installation Instructions for Users

### For End Users:

**Download & Install APK:**

1. **Download** APK file to your Android device
2. **Open** device Settings
3. Navigate to **Security** or **Privacy**
4. Enable **"Install unknown apps"** or **"Unknown sources"**
   - For Android 8+: Enable for specific app (e.g., Chrome, Files)
5. **Open** the downloaded APK file
6. Tap **"Install"**
7. Wait for installation
8. Tap **"Open"** to launch app

**First Launch:**
- App will show splash screen
- Check internet connection
- Website will load automatically

---

## 📄 Release Notes Template

Create release notes for each version:

```
FX Copy Trade - Version 1.0.0
Release Date: [Date]

What's New:
- Initial release
- WebView integration for fxcopytrade.online
- Splash screen with internet check
- Pull-to-refresh functionality
- File upload/download support
- Back button navigation
- Exit confirmation dialog

Requirements:
- Android 5.0 or higher
- Internet connection required

File Information:
- Package: com.fxcopytrade.app
- Version Code: 1
- Version Name: 1.0.0
- File Size: [XX] MB
- MD5: [checksum]
```

---

## 🎯 Next Steps After Building

1. **Test APK** thoroughly
2. **Create release notes**
3. **Take screenshots** for store listing
4. **Write app description**
5. **Prepare privacy policy** (if publishing)
6. **Choose distribution method**
7. **Share with beta testers** first
8. **Collect feedback**
9. **Fix any issues**
10. **Publish final version**

---

## 📞 Support

For build issues:
- Check Gradle console for errors
- Review ProGuard rules if app crashes
- Test with debug APK first
- Verify all permissions in manifest

---

**🎉 Congratulations on building your APK!**

**Built with ❤️ for FX Copy Trade**
