# 🪙 Gold Zakat Estimator App

[![Android Studio](https://img.shields.io/badge/Android_Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)](https://developer.android.com/studio)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/)

[cite_start]An intuitive Android mobile application built using **Java** to accurately calculate and estimate the annual zakat payment required for gold holdings based on religious criteria[cite: 5].

---

## 🎨 UI & Design Palette
The application layout relies on a clean, modern, and dedicated color setup:
* **Background tint (Light):** `#BDE8F5`
* **Elements & Primary Accent:** `#4988C4`
* **Toolbar / Action Bar Accent:** `#1C4D8D`
* **Deep Headings / Primary Text:** `#0F2854`

---

## 🚀 Key Features

* [cite_start]**Comprehensive Inputs:** Takes into account the gold weight (grams), type selection (Keep or Wear), and current market pricing per gram[cite: 6, 7, 8, 9].
* [cite_start]**Smart Business Logic:** Adjusts calculation algorithms automatically relative to thresholds ($X$ grams) matching official criteria (85g for Keeping, 200g for Wearing)[cite: 8, 16].
* [cite_start]**Native Share Functionality:** Integrates an Android Action Bar Share button allowing seamless application URL sharing[cite: 23].
* [cite_start]**Responsive Validations:** Implements protective input error handling and notice indicators to optimize app accessibility[cite: 30].

---

## 🧮 Calculation Logic

[cite_start]The program automatically evaluates user data against specified guidelines[cite: 10, 11, 12, 13, 14, 15]:

1. **Total Value of Gold:**
   $$\text{Total Value} = \text{Weight (grams)} \times \text{Current Value per gram}$$

2. **Zakat Payable Value:**
   $$\text{Payable Value} = (\text{Weight} - X) \times \text{Current Value per gram}$$
   [cite_start]*(Where $X = 85\text{g}$ for keep and $200\text{g}$ for wear. If weight is below $X$, payable value defaults to 0)[cite: 16, 18].*

3. **Total Zakat Contribution:**
   $$\text{Total Zakat} = 2.5\% \times \text{Zakat Payable Value}$$

---

## 📊 Evaluation Test Cases

[cite_start]The application calculates metrics corresponding to the expected benchmark criteria[cite: 17, 18]:

| Weight (g) | Type | Gold Value / g | Expected Payable Value | Expected Zakat |
| :--- | :--- | :--- | :--- | :--- |
| **100g** | Keep | RM 280 | RM 4,200.00 | RM 105.00 |
| **150g** | Wear | RM 280 | RM 0.00 | RM 0.00 |
| **300g** | Wear | RM 250 | RM 25,000.00 | RM 650.00 |
| **90g** | Keep | RM 250 | RM 1,250.00 | RM 31.25 |

---

## 📽️ Video Demonstration
You can check out the full walkthrough and evaluation demonstration of this app on YouTube:
🔗 [Watch the App Presentation on YouTube](YOUR_YOUTUBE_VIDEO_URL_HERE)

---

## 👥 Developer Information & Copyright
* **Developer:** Your Full Name
* **Student ID:** 2026XXXXX
* [cite_start]**Course Assignment:** Mobile Technology Individual Project [cite: 1, 2]

&copy; 2026 Your Name. All Rights Reserved. [cite_start]Manufactured for academic submission requirements[cite: 1, 22].
