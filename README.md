# Safe Unsafe App

This project is a mobile application designed to use on-device AI to generate recommendations for driver behaviors, inspired by State Farm's Safe and Save.

| Safe Driver | Average Driver | Unsafe driver |
|-------------|--------------|--------------------|
| ![Screenshot 1](https://github.com/user-attachments/assets/5c970d16-e781-4d42-abd2-48e77c8bf1b4) | ![Screenshot 2](https://github.com/user-attachments/assets/fa750faf-6a21-4d67-8b1d-3bb32e26eb82) | ![Screenshot 3](https://github.com/user-attachments/assets/9fb859d3-c730-43a7-98b3-0f0554264011) |

## Inspiration

The idea for this project came from analyzing State Farm's android app. I reviewed the users feedback to identify problems the users were facing. While most of them were more about the company rather than the app I found these that caught my attention:

![Inspiration Screenshot 2](https://github.com/user-attachments/assets/30b5a94a-a7b5-432f-b365-ed2834ea3a8f)  

![Inspiration Screenshot 3](https://github.com/user-attachments/assets/74dc0853-5cdc-401f-a6be-f06f55bb7e1b)

![Inspiration Screenshot 4](https://github.com/user-attachments/assets/2a32cc25-0d5c-43f6-8f4d-dc040f474a98)

![Inspiration Screenshot 5](https://github.com/user-attachments/assets/701d007e-1ae6-4c45-b955-10b95ed79a92)

This is the screen I used to inspire the UI for this project:

![Inspiration Screenshot 1](https://github.com/user-attachments/assets/b4974196-f324-424b-9155-45226620d6c0)  

## Technologies Used

- **Kotlin:** Primary programming language for Android development.  
- **Compose:** Modern toolkit for building native UI in a declarative way.  
- **MVVM:** Model-View-ViewModel architecture for clean separation of concerns.  
- **Coroutines:** For asynchronous programming and managing background tasks efficiently.  
- **Hilt:** Dependency injection framework to simplify component management.  
- **Testing with MockK:** Unit testing library for mocking and verifying behavior in tests.  
- **Gemini on Device / AI Core:** On-device machine learning for real-time data processing and insights.
