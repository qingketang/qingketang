# GraphQL Example

## createClassroom

```graphql
mutation CreateClassroom($params: ClassroomCreateParams!) {
    createClassroom(params: $params) {
        id
        no
        name
        userNum
        createdAt
        updatedAt
    }
}
```

```json
{
  "params": {
    "name": "example classroom"
  }
}
```

## deleteClassroom

```graphql
mutation DeleteClassroom($id: ID!) {
    deleteClassroom(id: $id) {
        ok
    }
}
```

```json
{
  "id": 1
}
```

## changeClassroomName

```graphql
mutation ChangeClassroomName($id: ID!, $name: String) {
    changeClassroomName(id: $id, name: $name) {
        ok
    }
}
```

```json
{
  "id": 1,
  "name": "new name"
}
```