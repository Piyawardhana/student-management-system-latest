import { useEffect, useState } from 'react';

export default function useTableFetch(url: string, currentPage?: number) {
  const [data, setData] = useState<null | any>(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<Error | null>(null);
  const pageSize = 10;

  useEffect(() => {
    async function fetchData() {
      setLoading(true);
      try {
        const paginatedUrl = `${url}?page=${currentPage}&size=${pageSize}`;
        const response = await fetch(paginatedUrl);
        if (!response.ok) {
          throw new Error('Error while fetching data!');
        }
        const data = await response.json();
        setData(data);
      } catch (error: any) {
        setError(error);
      } finally {
        setLoading(false);
      }
    }
    fetchData();
  }, [url, currentPage]);

  return { data, loading, error };
}
