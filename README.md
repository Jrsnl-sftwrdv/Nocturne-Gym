# Nocturne Gym Management System

A gym membership management and tracking system that uses **Near Field Communication (NFC)** technology to simplify member identification, gym check-ins, and membership evaluation.

## Overview

Nocturne Gym is a gym management application designed to help gym administrators manage member records, monitor gym attendance, and evaluate membership activity through NFC-enabled identification cards.

Instead of manually searching for member records or recording attendance, members can use their assigned NFC cards to identify themselves at the gym's check-in point.

The system aims to provide a more organized approach to membership management while maintaining accurate attendance records and accessible member information.

## Core Features

### Member Management
- Register new gym members.
- Retrieve all registered members.
- View individual member profiles.
- Update member information.
- Delete member records.
- Assign unique NFC card identifiers to members.
- Prevent duplicate NFC card registrations.

### NFC-Based Check-In
- Identify members using their registered NFC card UID.
- Associate NFC card scans with individual member accounts.
- Record gym attendance and check-in timestamps.
- Maintain a history of member visits.

### Membership Evaluation
- Monitor member attendance and activity.
- Evaluate membership engagement through check-in records.
- Provide attendance information to assist gym administrators in assessing member activity.

> Note: NFC check-in tracking and membership evaluation are planned system capabilities unless already implemented in the current codebase.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | Primary programming language |
| Spring Boot | Backend application framework |
| Spring Data JPA | Database interaction and persistence |
| MySQL | Relational database |
| Lombok | Reduces boilerplate code |
| Jakarta Validation | Request data validation |
| NFC | Member identification technology |

## Member Information

The system currently maintains the following member information:

| Field | Description |
|---|---|
| `id` | Unique member identifier |
| `name` | Member's full name |
| `cardUid` | Unique NFC card identifier |
| `smsNumber` | Member's contact number |
| `gender` | Member's gender |
| `email` | Member's email address |
| `createdAt` | Member registration timestamp |

## API Endpoints

Base URL: `/api/members`

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/members` | Retrieve all members |
| GET | `/api/members/{id}` | Retrieve a member by ID |
| POST | `/api/members` | Register a new member |
| PATCH | `/api/members/{id}` | Partially update member information |
| DELETE | `/api/members/{id}` | Delete a member |

*Endpoints are subject to change as development progresses.*

## Sample Request

### Register a Member

**POST** `/api/members`

```json
{
    "name": "John Doe",
    "cardUid": "NFC-2026-0001",
    "smsNumber": "09171234567",
    "gender": "MALE",
    "email": "johndoe@gmail.com"
}
```

The system automatically generates the member ID and registration timestamp.

## Database Design

The application currently uses a MySQL database named `gym`.

The primary entity is `Member`, which represents an individual registered gym member.

The `card_uid` field has a unique constraint to ensure that an NFC card cannot be assigned to multiple members.

Additional entities for attendance records and membership evaluation may be introduced as the system evolves.

## Project Structure

```text
src/
└── main/
    ├── java/
    │   └── Nocturne/
    │       └── Gym/
    │           ├── controllers/
    │           ├── services/
    │           ├── repositories/
    │           ├── models/
    │           │   └── DTOS/
    │           │       ├── Requests/
    │           │       └── Responses/
    │           └── ExceptionHandler/
    │
    └── resources/
        └── application.properties
```

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java JDK
- Maven
- MySQL Server
- An IDE such as IntelliJ IDEA

### Installation

1. Clone the repository:

```bash
git clone <your-repository-url>
```

2. Navigate to the project directory:

```bash
cd Nocturne-Gym
```

3. Create the MySQL database:

```sql
CREATE DATABASE gym;
```

4. Configure your database credentials in `application.properties`.

5. Run the application:

```bash
mvn spring-boot:run
```

The application should now be running on:

```text
http://localhost:8080
```

## Future Improvements

- [ ] Complete member registration and management endpoints.
- [ ] Implement partial member updates using PATCH.
- [ ] Integrate NFC card reader hardware.
- [ ] Develop an NFC-based gym check-in workflow.
- [ ] Create attendance and check-in history records.
- [ ] Implement membership activity evaluation.
- [ ] Develop an administrative dashboard.
- [ ] Generate attendance and membership reports.

## Project Goal

Nocturne Gym aims to make gym operations more efficient through technology-driven membership management and attendance monitoring.

By combining backend application development, relational database management, and NFC-based identification, the project seeks to establish a more streamlined and reliable gym management experience.
