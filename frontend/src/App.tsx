
import './App.css';
import { EntityTable, EntityTableColumn } from './components/table/EntityTable';

function App() {
 const data = [
  { id: 1, name: 'Alice', age: 25 },
  { id: 2, name: 'Bob', age: 30 },
  { id: 3, name: 'Charlie', age: 35 },
 ]

  return (
    <EntityTable data={data}>
      <EntityTableColumn
        columnHeader="ID"
        columnName="id"
        filter={(filterValue, columnValue) => columnValue.toString().includes(filterValue)}
      />
      <EntityTableColumn
        columnHeader="Name"
        columnName="name"
        filter={(filterValue, columnValue) => columnValue.toLowerCase().includes(filterValue.toLowerCase())}
      />
      <EntityTableColumn
        columnHeader="Age"
        columnName="age"
        filter={(filterValue, columnValue) => columnValue.toString().includes(filterValue)}
      />
    </EntityTable>
  );
}

export default App;
