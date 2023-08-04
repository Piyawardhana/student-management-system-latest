import React, { useEffect, useState } from "react";

//Column props interface
interface ITableColumnProps<T> {
  columnHeader: string;
  columnName: keyof T;
  filter?: (value: string, columnValue: any) => boolean;
}

//Table props interface
interface ITableProps<T> {
  data: T[];
  children: React.ReactElement<ITableColumnProps<T>>[];
}

//TableColumn component
export function EntityTableColumn<T>({
  columnHeader,
  columnName,
  filter,
}: ITableColumnProps<T>) {
  return null;
}

//Table component
export function EntityTable<T>({ data, children }: ITableProps<T>) {
  //Get the EntityTableColumn children as an array of ITableColumnProps
  const columns = React.Children.toArray(children) as React.ReactElement<
    ITableColumnProps<T>
  >[];

  const [filters, setFilters] = useState<{
    [key: string]: ((value: any) => Boolean) | undefined;
  }>({});
  const [filterInputs, setFilterInputs] = useState<{ [key: string]: string }>(
    {}
  );

  useEffect(() => {
    setFilters(
      columns.reduce((acc, column) => {
        if (column.props.filter) {
          acc[String(column.props.columnName)] = column.props.filter.bind(
            null,
            filterInputs[String(column.props.columnName)] || ""
          );
        }
        return acc;
      }, {} as { [key: string]: ((value: any) => boolean) | undefined })
    );
  }, [filterInputs]);

  const handleInputChange = (
    event: React.ChangeEvent<HTMLInputElement>,
    columnName: keyof T
  ) => {
    setFilterInputs((prevState) => ({
      ...prevState,
      [String(columnName)]: event.target.value,
    }));
  };

  const filterData = data.filter((item) =>
    columns.every((column) => {
      const filter = filters[String(column.props.columnName)];
      return !filter || filter(item[column.props.columnName]);
    })
  );

  return <div></div>;
}
