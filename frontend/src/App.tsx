import { useState } from 'react';
import './App.css';
import { EntityTable, EntityTableColumn } from './components/table/EntityTable';
import useTableFetch from './hooks/useFetch';

function App() {
  const [currentPage, setCurrentPage] = useState(0);
  const { data, loading, error } = useTableFetch('/students', currentPage);

  if (loading) {
    return <p>Loading...</p>;
  }

  // test frontend workflows
  if (error) {
    return <p>Error: {error.message}</p>;
  }

  return (
    <EntityTable data={data || []} currentPage={currentPage} setCurrentPage={setCurrentPage}>
      <EntityTableColumn columnHeader="ID" columnName="id" />
      <EntityTableColumn columnHeader="First Name" columnName="firstName" />
      <EntityTableColumn columnHeader="Last Name" columnName="lastName" />
      <EntityTableColumn columnHeader="Age" columnName="age" />
    </EntityTable>
  );
}

export default App;
