import React, {useEffect, useRef, useState} from 'react';


export const ReactiveListComponent = () => {
    const [messages, setMessages] = useState([])
    const [eventRaise, setEventRaise] = useState()
    const [eventSource, setEventSource] = useState()

    const variableRef = useRef();

    useEffect(() => {
        variableRef.current = eventRaise;
        if (eventRaise) {
            let newPerson = eventRaise.data
            if(!messages.some(x=>x.data===newPerson))
                setMessages([...messages, {data: eventRaise.data, receiveTime: new Date()}])
            console.log(eventSource)
        }
    }, [eventRaise]);


    // useEffect(() => {
    //     if (!eventSource) {
    //         console.log(eventSource)
    //         //onMessage(setEventRaise)
    //     }
    // }, [eventRaise])


    useEffect(() => {
        if (!eventSource) {
            let es = new EventSource("http://localhost:9091/simple-test");
            es.onmessage = e => {
                setEventRaise(e)
                //console.log(e)
            }
            setEventSource(es)
        } else {
            console.log()
        }
    })


    return (
        <div>
            List:
            <ul>
                {
                    messages.map((message) => {
                        return <li key={message.data}>{message.data}</li>
                    })
                }
            </ul>
        </div>
    )
}