import { useState } from 'react';
import './App.css';
import { EntityTable, EntityTableColumn } from './components/table/EntityTable';
import useFetch from './hooks/useFetch';

function App() {
  const { data, loading, error } = useFetch('/api/v1/students');

  if (loading) {
    return <p>Loading...</p>;
  }

  if (error) {
    return <p>Error: {error}</p>;
  }

  return (
    <EntityTable data={data || []}>
      <EntityTableColumn columnHeader="ID" columnName="id" />
      <EntityTableColumn columnHeader="First Name" columnName="firstName" />
      <EntityTableColumn columnHeader="Last Name" columnName="lastName" />
      <EntityTableColumn columnHeader="Age" columnName="age" />
    </EntityTable>
  );
}

export default App;
