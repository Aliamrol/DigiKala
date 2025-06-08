# 📱 DigiKala Demo - Android App (Jetpack Compose)

A modern, maintainable, and scalable demo version of the **DigiKala** shopping application built with **Jetpack Compose**, following best practices of **Clean Architecture**, **MVVM**, and **SOLID principles**.

> This project showcases the use of modern Android development tools and design patterns. The goal is to demonstrate a clean, modular, and production-ready setup using cutting-edge libraries and architecture.

---

## 🧱 Tech Stack & Tools

| Category               | Technology / Tool                           |
|------------------------|---------------------------------------------|
| Language               | Kotlin                                      |
| UI Toolkit             | Jetpack Compose                             |
| Navigation             | Compose Navigation                          |
| Image Loading          | Coil                                        |
| Dependency Injection   | Hilt                                        |
| Networking             | Retrofit + OkHttp                           |
| Local Storage          | Room Database, DataStore                    |
| Architecture Pattern   | MVVM + Clean Architecture                   |
| Reactive Flow          | Kotlin Coroutines, Flow                     |


---

## 🏗️ Architecture Overview

This project is structured using **Clean Architecture** principles. The layers are clearly separated to enforce a single responsibility and support scalability and testability:



Presentation (UI Layer - Jetpack Compose)
↓
ViewModel (State Management - Kotlin Flow)
↓
UseCase (Business Logic)
↓
Repository (Interface Abstraction)
↓
Data Layer (Remote APIs - Retrofit, Local DB - Room, Preferences - DataStore)


Each layer is decoupled and testable. Dependency Injection is handled via **Hilt** across all components.

---

## 📁 Project Structure
```
com.example.digikala
├── core/ → Device and platform utilities
├── data/ → Remote APIs, models, DataStore, local caching
├── di/ → Hilt dependency injection modules
├── navigation/ → Compose-based screen navigation setup
├── repository/ → Interface definitions for business logic access
├── ui/ → Screens, reusable UI components, themes
├── utils/ → Constants, locale and digit helpers
├── viewModel/ → ViewModels with state exposure via Flow
├── MainActivity.kt → App startup and nav host
├── App.kt → Jetpack Compose & Hilt setup

```

