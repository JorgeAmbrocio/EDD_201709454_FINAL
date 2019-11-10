

    var chart_config = {
        chart: {
            container: "#basic-example",
            
            connectors: {
                type: 'bCurve'
            },
            animateOnInit: true,
            
            node: {
                collapsable: true,
                HTMLclass: 'nodeExample1'
            },
            animation: {
                nodeAnimation: "easeOutBounce",
                nodeSpeed: 700,
                connectorsAnimation: "bounce",
                connectorsSpeed: 700
            }
        },
        nodeStructure: {         
            text: {
                name: "Fericardoo",
                title: "201296742",
            },
	    
            children: [
                {
                    text:{
                        name: "Juan",
                        title: "82283181"
                    },
                    
                    children: [
                        {
                            text:{
                                name: "Checha",
                                title: "1243556567"
                            }
                        },
                        {
                            text:{
                                name: "Cherk",
                                title: "13354668"
                            }
                        }
                    ]
                },
                {
                    text:{
                        name: "May",
                        title: "124778799",
                    },
                    
                    children: [
                        {
                            text:{
                                name: "Alice ",
                                title: "545217972"
                            }
                            
                        },
                        {
                            text:{
                                name: "Gary Stu",
                                title: "23668773576"
                            }
                            
                        }
                    ]
                }
            ]
        }
    };

