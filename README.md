# Stellar Stories Interactive Learning App

A JavaFX educational application created for the **NASA Space Apps Challenge (2025)**.  
Developed collaboratively over two days, this app visually explains **solar flares**, **coronal mass ejections (CMEs)**, and **space weather impacts on Earth** through interactive slideshows and simple animations.

---

## Overview

The Solar Storm Interactive Learning App helps users understand how solar activity affects Earth’s technology and environment.  
The project combines real NASA imagery, visual storytelling, and JavaFX interactivity to create a short digital learning experience suitable for classrooms or public outreach.

Users can navigate from a **main menu** to four themed modules, each designed as a mini slideshow or tutorial:
1. **Solar Flares**  
2. **Coronal Mass Ejections (CMEs)**  
3. **Impacts on Earth**  
4. **Protecting Earth**

---

## 🚀 Key Features

- **Main Menu Navigation** – Clean JavaFX UI with buttons linking to each educational module.  
- **Interactive Slideshows** – Each topic uses multiple slides, combining NASA visuals, text, and transitions.  
- **Slider-Based Animation** – The Solar Flare and CME modules include draggable sliders that change images to simulate the stages of a solar event.  
- **Educational Focus** – Explains space weather concepts like flares, CMEs, auroras, and their real-world impacts on satellites, aviation, and power grids.  
- **Custom Graphics** – Canva and NASA public-domain images layered together for clarity and engagement.  

---

## Example Module: Solar Flares

The `SolarFlare` class demonstrates how JavaFX can be used to link a slider to a sequence of images and text descriptions.  
As the user moves the slider, the app updates:
- The main image (representing flare progression)
- The caption text describing each stage

This creates an animated, educational “mini-simulation” of a solar flare’s life cycle.

---

## Technologies

| Category | Tools & Frameworks |
|-----------|--------------------|
| **Language** | Java 17 |
| **UI Framework** | JavaFX |
| **Design Assets** | Canva (illustrations) + NASA Image Library |
| **Build Tool** | Maven |

---

## Installation and Execution

### Prerequisites
- Java 17 or later  
- Maven 3.8+  

### Run Locally
```bash
git clone https://github.com/yourusername/solar-storm-interactive.git
cd solar-storm-interactive
mvn clean javafx:run
```

## Usage

- **Main Menu:** Select one of four modules to explore — Solar Flares, CMEs, Impacts on Earth, or Protecting Earth.  
- **Slideshow Navigation:** Move through educational slides featuring images and explanations.  
- **Interactive Modules:** In Solar Flare and CME sections, drag the slider to simulate the progression of solar events.  
- **Return to Menu:** Use the Exit button to go back to the main menu at any time.

---

## Notes for Reviewers

This project was created collaboratively over two days for the **NASA Space Apps Challenge 2025**.  
It demonstrates:
- Event-driven **JavaFX UI development**.  
- **Object-oriented architecture** across multiple educational modules.  
- Integration of **multimedia elements** (text, imagery, and sliders).  
- Emphasis on **visual learning and accessibility** in STEM education.

---

## Authors

**Nye Tenerelli**  
- Role: JavaFX development, project structure, app logic.  
- Email: nyetenerelli@gmail.com  
- LinkedIn: [www.linkedin.com/in/nye-tenerelli-ba546023b](https://www.linkedin.com/in/nye-tenerelli-ba546023b)

**Luis Lopez**  
- Role: JavaFX development, project structure, app illustration design.
- Email: lopezlui@grinnell.edu
---

## Acknowledgments

- **NASA Space Apps Challenge (2025)** – for inspiration and challenge materials.  
- **NASA Image & Video Library** – for public-domain educational visuals.  
- **Canva** – for assisting with layout and illustration creation.  
- **Open-Source JavaFX Community** – for documentation and UI guidance.


