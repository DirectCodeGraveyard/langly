/*
  Metadata for Langly
*/

/* Language List */
languages = [
    [
        name: "Groovy",
        extensions: [
            ".groovy",
            ".gvy"
        ],
        related: [
            "Java"
        ]
    ],
    [
        name: "Java",
        extensions: [
            ".java"
        ]
    ],
    [
        name: "JavaScript",
        extensions: [
            ".js"
        ]
    ],
    [
        name: "Scala",
        extensions: [
            ".scala"
        ]
    ],
    [
        name: "Ruby",
        extensions: [
            ".rb"
        ]
    ],
    [
        name: "Python",
        extensions: [
            ".py"
        ]
    ],
    [
        name: "JSON",
        type: "data",
        extensions: [
            ".json"
        ]
    ],
    [
        name: "CoffeeScript",
        extensions: [
            ".coffee"
        ]
    ],
    [
        name: "CSON",
        type: "data",
        extensions: [
            ".cson"
        ],
        related: [
            "JSON",
            "CoffeeScript"
        ]
    ],
    [
        name: "C",
        extensions: [
            ".c",
            ".w"
        ]
    ],
    [
        name: "C++",
        extensions: [
            ".cpp",
            ".h",
            ".cxx",
            ".c++"
        ]
    ],
    [
        name: "D",
        extensions: [
            ".d",
            ".di"
        ]
    ],
    [
        name: "HTML",
        type: "markup",
        extensions: [
            ".html",
            ".htm",
            ".xhtml"
        ]
    ],
    [
        name: "Go",
        extensions: [
            ".go"
        ]
    ],
    [
        name: "Bash",
        extensions: [
            ".sh",
            ".bash"
        ]
    ],
    [
        name: "Erlang",
        extensions: [
            ".erl",
            ".hrl"
        ]
    ],
    [
        name: "ANTLR",
        extensions: [
            ".g4"
        ]
    ],
    [
        name: "Markdown",
        extensions: [
            ".md",
            ".markdown"
        ]
    ],
    [
        name: "C#",
        extensions: [
            ".cs"
        ]
    ],
    [
        name: "CSS",
        extensions: [
            ".css"
        ]
    ],
    [
        name: "Ceylon",
        extensions: [
            ".ceylon"
        ]
    ],
    [
        name: "Less",
        type: "markup",
        extensions: [
            ".less"
        ],
        related: [
            "CSS"
        ]
    ],
    [
        name: "Lua",
        extensions: [
            ".lua",
            ".nse",
            ".rbxs"
        ]
    ],
    [
        name: "PHP",
        extensions: [
            ".php",
            ".php3",
            ".php4",
            ".php5"
        ]
    ],
    [
        name: "Dogescript",
        extensions: [
            ".djs"    
        ]
    ],
    [
        name: "Fourth",
        extensions: [
            ".fth",
            ".4th"
        ]
    ],
    [
        name: "JSON5",
        type: "data",
        extensions: [
            ".json5"    
        ],
        related: [
            "JSON"    
        ]
    ],
    [
        name: "Kotlin",
        extensions: [
            ".kt",
            ".ktm",
            ".kts"
        ]
    ],
    [
        name: "XML",
        type: "markup",
        extensions: [
            ".xml"    
        ]
    ],
    [
        name: "YAML",
        extensions: [
            ".yml",
            ".yaml"
        ]
    ],
    [
        name: "Jade",
        type: "markup",
        extensions: [
            ".jade"    
        ],
        related: [
            "HTML"    
        ]
    ]
]

/* File Extensions that are commonly binary files */
binary_extensions = [
    ".jar",
    ".zip",
    ".gz",
    ".tar",
    ".bz2",
    ".obj",
    ".exe"
]

/*
  Regular Expressions Matching Vendor Files
  No escaping is necessary, as it is auto-quoted.
*/
vendor = [
    'README',
    'README.(.*)',
    '.gitignore',
    '.gitattributes',
    '.gitmodules',
    '(^|/)gradle/wrapper/(.*)'
]
