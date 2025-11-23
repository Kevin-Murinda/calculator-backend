# Calculator Backend 
A RESTful API calculator service built with Spring Boot that performs arithmetic
   operations (addition, subtraction, multiplication, division, modulo, and
   exponentiation). The application follows a layered architecture with DTOs for
   API communication, a domain model for business logic, and comprehensive
   exception handling. It validates incoming requests using Jakarta Bean
   Validation, handles edge cases like division by zero, and returns structured
   JSON responses. The API exposes endpoints at /api/calculator/calculate for
   performing calculations and includes CORS configuration to allow communication
   with the React frontend.
