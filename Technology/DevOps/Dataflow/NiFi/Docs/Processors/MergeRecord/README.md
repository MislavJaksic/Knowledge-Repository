## MergeRecord

Merges schema defined FlowFiles into a single FlowFile.  

### Properties

| Name                       | Description |
|----------------------------|-------------|
| Record Reader              | Input schema. |
| Record Writer              | Output schema. |
| Merge Strategy             |             |
| Correlation Attribute Name | Attribute by which the FlowFiles should be grouped up and merged. |
| Attribute Strategy         |             |
| Minimum Number of Records  | Minimum number of records before merging. See Max Bin Age. |
| Maximum Number of Records  |             |
| Minimum Bin Size           |             |
| Maximum Bin Size           |             |
| Max Bin Age                | Maximum wait time before merging records. See Minimum Number of Records. |
| Maximum Number of Bins     |             |

### Usage

Concatenates FlowFiles that share the same attribute or schema or both. Merges after a set number of time or when it has enough records to merge, whichever comes first.  
