import { useEffect, useState } from "react";

function useFetch(url: string, options?: any) {
    const [data, setData] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
console.log(url);
    useEffect(() => {
        async function fetchdata() {
            setLoading(true);
            try {
                const response  = await fetch(url, options);
                if (!response.ok) {
                    throw new Error('Faild to fetch data from the server');
                }
                const data = await response.json();
                setData(data);
            } catch (error: any) {
                setError(error);
            } finally {
                setLoading(false);
            }
        }
        fetchdata();
    }, [url, options])

    return { data, loading, error };
}

export default useFetch;